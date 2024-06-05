/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Admin.DemoAdmin.Service;

/**
 *
 * @author DAO
 */
import com.Admin.DemoAdmin.Entity.UserNotification;
import java.util.List;

public interface UserNotificationService {
    UserNotification createUserNotification(UserNotification userNotification);
    List<UserNotification> getUserNotificationsByUserId(int userId);
}