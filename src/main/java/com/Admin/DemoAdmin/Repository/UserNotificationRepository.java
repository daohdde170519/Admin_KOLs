/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Admin.DemoAdmin.Repository;

/**
 *
 * @author DAO
 */
import com.Admin.DemoAdmin.Entity.UserNotification;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserNotificationRepository extends JpaRepository<UserNotification, Integer> {
    List<UserNotification> findByUserId(int userId);
}
