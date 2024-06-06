/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.Service;

/**
 *
 * @author DAO
 */
import com.Admin.DemoAdmin.DTOs.UserDTO;
import com.Admin.DemoAdmin.Entity.User;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User findById(Integer userId);
    List<User> findAll();
    User save(User user);
    List<UserDTO> getAllUserDTOs();
    Page<UserDTO> findPaginated(Pageable pageable);
    UserDTO getUserDTOById(Integer userId);
    void deleteUserById(Integer id);
    Page<User> pageUsers(int pageNo);
    Page<UserDTO> searchUsers(String keyword, Pageable pageable);
    Page<UserDTO> searchUsersWithBan(String keyword, Pageable pageable);
    Page<UserDTO> searchUsersWithUnBan(String keyword, Pageable pageable);
    List<Long> getUserCountByMonthAndYear(int year);
    List<Integer> getYearsWithUsers();
}

