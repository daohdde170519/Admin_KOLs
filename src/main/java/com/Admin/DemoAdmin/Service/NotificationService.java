/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Admin.DemoAdmin.Service;

/**
 *
 * @author DAO
 */
import com.Admin.DemoAdmin.Entity.Notification;
import java.util.List;

public interface NotificationService {
    Notification createNotification(Notification notification);
    List<Notification> getAllNotifications();
}

