/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.Service.Impl;

/**
 *
 * @author DAO
 */
import com.Admin.DemoAdmin.Entity.UserNotification;
import com.Admin.DemoAdmin.Repository.UserNotificationRepository;
import com.Admin.DemoAdmin.Repository.UserRepository;
import com.Admin.DemoAdmin.Service.UserNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserNotificationServiceImpl implements UserNotificationService {

    @Autowired
    private UserNotificationRepository userNotificationRepository;
    @Override
    public UserNotification createUserNotification(UserNotification userNotification) {
        return userNotificationRepository.save(userNotification);
    }

    @Override
    public List<UserNotification> getUserNotificationsByUserId(int userId) {
        return userNotificationRepository.findByUserId(userId);
    }
}

