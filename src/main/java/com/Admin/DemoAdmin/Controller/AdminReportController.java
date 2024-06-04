/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.Controller;

import com.Admin.DemoAdmin.Entity.Report;
import com.Admin.DemoAdmin.Service.ReportService;
import com.Admin.DemoAdmin.Service.UserService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
