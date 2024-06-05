/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.Controller;

import com.Admin.DemoAdmin.Entity.Notification;
import com.Admin.DemoAdmin.Service.NotificationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author DAO
 */
@Controller
@RequestMapping("/admin")
public class NotificationViewController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/notifications")
    public String viewNotifications(Model model) {
        List<Notification> notifications = notificationService.getAllNotifications();
        model.addAttribute("notifications", notifications);
        return "notification/notification";
    }
}
