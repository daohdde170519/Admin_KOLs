/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.Controller;

import com.Admin.DemoAdmin.Entity.Comment;
import com.Admin.DemoAdmin.Entity.Notification;
import com.Admin.DemoAdmin.Entity.Report;
import com.Admin.DemoAdmin.Entity.TypeNotification;
import com.Admin.DemoAdmin.Repository.CommentRepository;
import com.Admin.DemoAdmin.Repository.ReportRepository;
import com.Admin.DemoAdmin.Service.NotificationService;
import com.Admin.DemoAdmin.Service.ReportService;
import com.Admin.DemoAdmin.Service.UserService;
import com.Admin.DemoAdmin.Service.ViolationCheckService;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author DAO
 */
@Controller
@RequestMapping("/admin/reports")
public class AdminReportController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private UserService userService;
    
    @Autowired
    private NotificationService notificationService;
    
        @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ViolationCheckService violationCheckService;
    
    @Autowired
    private ReportRepository reportRepository;
    
    @GetMapping
    public String listReports(@RequestParam("page") Optional<Integer> page,
                              @RequestParam("size") Optional<Integer> size,
                              @RequestParam(value = "keyword", required = false) String keyword,
                              Model model) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);

        Pageable pageable = PageRequest.of(currentPage - 1, pageSize);
        Page<Report> reportPage;

        if (keyword != null && !keyword.isEmpty()) {
            reportPage = reportService.searchCategories(keyword, pageable);
            model.addAttribute("keyword", keyword);
        } else {
            reportPage = reportService.findPaginated(pageable);
        }

        model.addAttribute("reportPage", reportPage);

        model.addAttribute("viewName", "admin/report/list_reports");

        return "admin-layout";
    }  
    
        @PostMapping("/sendNotification")
    public String sendNotification(@RequestParam("userId") int userId, @RequestParam("message") String message) {
        // Tạo đối tượng Notification mới
        Notification notification = new Notification();
        notification.setUser(userService.findById(userId));
        notification.setContent(message);
        notification.setCreateAt(ZonedDateTime.now());
        notification.setType(TypeNotification.ACCOUNT);
        // Lưu thông báo
         notificationService.createNotification(notification);
        return "redirect:/admin/reports"; // Điều hướng lại trang danh sách báo cáo sau khi gửi thông báo
    }
    
    @GetMapping("/submit")
    public String showReportForm(Model model) {
        model.addAttribute("report", new Report());
        return "reportForm";
    }

    @PostMapping("/submit1")
    public String submitReport(@ModelAttribute("report") Report report, Model model) {
        report.setCreateDate(new Date());
        // Save the report in the database
        reportRepository.save(report);

        // Get the reported comment
        Comment reportedComment = commentRepository.findById(report.getReportedComment().getCommentId()).orElse(null);
        if (reportedComment == null) {
            model.addAttribute("message", "Comment not found");
            return "reportForm";
        }

        // Check for violation words
        violationCheckService.checkCommentForViolations(reportedComment);
        return "reportForm";
    }
    
    @PostMapping("/delete/{id}")
    public String deleteReport(@PathVariable("id") int reportId, Model model) {
        try {
            reportService.deleteReportById(reportId);
            model.addAttribute("message", "Report deleted successfully");
        } catch(Exception ex){
            model.addAttribute("message", "Report deleted unSuccessfully");
        }
        return "redirect:/admin/reports"; // Redirect to the list of reports
    }
}
