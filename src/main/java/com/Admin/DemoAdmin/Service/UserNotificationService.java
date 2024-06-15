/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Admin.DemoAdmin.Service;

/**
 *
 * @author DAO
 */
import com.Admin.DemoAdmin.Entity.User;
import com.Admin.DemoAdmin.Entity.UserNotification;
import java.util.List;
import org.springframework.stereotype.Service;
@Service
public interface UserNotificationService {
    UserNotification createUserNotification(UserNotification userNotification);
    List<UserNotification> getUserNotificationsByUserId(int userId);
    void sendViolationNotification(User reportedUser, int violationLevel);
}