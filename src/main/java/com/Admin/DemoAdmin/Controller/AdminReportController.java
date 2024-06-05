/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.Controller;

import com.Admin.DemoAdmin.Entity.Notification;
import com.Admin.DemoAdmin.Entity.Report;
import com.Admin.DemoAdmin.Entity.UserNotification;
import com.Admin.DemoAdmin.Service.NotificationService;
import com.Admin.DemoAdmin.Service.ReportService;
import com.Admin.DemoAdmin.Service.UserNotificationService;
import com.Admin.DemoAdmin.Service.UserService;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    private UserNotificationService userNotificationService;
    
    @Autowired
    private NotificationService notificationService;
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

        return "/report/list_reports";
    }  
    
        @PostMapping("/sendNotification")
    public String sendNotification(@RequestParam("userId") int userId, @RequestParam("message") String message) {
        // Tạo đối tượng Notification mới
        Notification notification = new Notification();
        notification.setMessage(message);
        notification.setNotificationDate(new Date());

        // Lưu thông báo
        Notification savedNotification = notificationService.createNotification(notification);

        // Gửi thông báo đến người dùng
        UserNotification userNotification = new UserNotification();
        userNotification.setUserId(userId);
        userNotification.setNotificationId(savedNotification.getNotificationId());
        userNotificationService.createUserNotification(userNotification);

        return "redirect:/admin/reports"; // Điều hướng lại trang danh sách báo cáo sau khi gửi thông báo
    }
}
