/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.Service.Impl;

/**
 *
 * @author DAO
 */
import com.Admin.DemoAdmin.Entity.Notification;
import com.Admin.DemoAdmin.Entity.User;
import com.Admin.DemoAdmin.Entity.UserNotification;
import com.Admin.DemoAdmin.Repository.NotificationRepository;
import com.Admin.DemoAdmin.Repository.UserNotificationRepository;
import com.Admin.DemoAdmin.Repository.UserRepository;
import com.Admin.DemoAdmin.Service.UserNotificationService;
import java.time.ZonedDateTime;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserNotificationServiceImpl implements UserNotificationService {

    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private UserNotificationRepository userNotificationRepository;

    @Override
    public UserNotification createUserNotification(UserNotification userNotification) {
        return userNotificationRepository.save(userNotification);
    }

    @Override
    public List<UserNotification> getUserNotificationsByUserId(int userId) {
        return userNotificationRepository.findByUser_UserId(userId);
    }

    @Override
    public void sendViolationNotification(User reportedUser, int violationLevel) {
        String message = "Your comment has been marked as violating with a severity level of " + violationLevel;
        Notification notification = new Notification();
        notification.setCreateAt(ZonedDateTime.now());
        notification.setContent(message);
        notificationRepository.save(notification);

        UserNotification userNotification = new UserNotification();
        userNotification.setUser(reportedUser);
        userNotification.setNotification(notification);
        userNotificationRepository.save(userNotification);
    }
}

