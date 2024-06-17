/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.Mapper;

import com.Admin.DemoAdmin.DTOs.UserDTO;
import com.Admin.DemoAdmin.Entity.User;
import org.springframework.stereotype.Component;

/**
 *
 * @author DAO
 */

@Component
public class UserMapper {

    public UserDTO toUserDTO(User user) {
        String banAction = user.isLocked() ? "Unban" : "Ban";
        String viewAction = "/admin/users/view/" + user.getUserId();
        
        return new UserDTO(
            user.getUserId(),
            user.getUsername(),
            user.getEmail(),
            user.getGender().toString(),
            user.getRole(),
            banAction,
            viewAction
        );
    }
}
