/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.Repository;

import com.Admin.DemoAdmin.DTOs.UserDTO;
import com.Admin.DemoAdmin.Entity.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DAO
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u  from User u ")
    Page<User> pageUser(Pageable pageable);
    
    @Query("select u from User u where u.email LIKE %?1% or u.username LIKE %?1% or u.gender LIKE %?1% or u.role LIKE %?1% ")
    Page<User> searchUsers(String keyword, Pageable pageable);
    
    
    @Query("SELECT COUNT(u), FUNCTION('MONTH', u.createdAt) FROM User u WHERE u.role = 'user' AND u.locked = false AND FUNCTION('YEAR', u.createdAt) = :year GROUP BY FUNCTION('MONTH', u.createdAt)")
    List<Object[]> findUserCountByMonthAndYear(int year);
    
    @Query("SELECT DISTINCT FUNCTION('YEAR', u.createdAt) FROM User u WHERE u.role = 'user' AND u.locked = false ORDER BY FUNCTION('YEAR', u.createdAt)")
    List<Integer> findYearsWithUsers();
}
