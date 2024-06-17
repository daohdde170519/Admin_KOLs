/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.Repository;

import com.Admin.DemoAdmin.DTOs.UserDTO;
import com.Admin.DemoAdmin.Entity.Gender;
import com.Admin.DemoAdmin.Entity.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DAO
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u  from User u ")
    Page<User> pageUser(Pageable pageable);
    
    @Query("SELECT u FROM User u WHERE " +
           "LOWER(u.email) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(u.username) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "u.gender = :gender OR " +
           "LOWER(u.role) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    Page<User> searchUsers(@Param("keyword") String keyword, @Param("gender") Gender gender, Pageable pageable);

    @Query("SELECT u FROM User u WHERE " +
           "(LOWER(u.email) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(u.username) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "u.gender = :gender OR " +
           "LOWER(u.role) LIKE LOWER(CONCAT('%', :keyword, '%'))) AND " +
           "u.locked = true")
    Page<User> searchUsersWithBan(@Param("keyword") String keyword, @Param("gender") Gender gender, Pageable pageable);

    @Query("SELECT u FROM User u WHERE " +
           "(LOWER(u.email) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(u.username) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "u.gender = :gender OR " +
           "LOWER(u.role) LIKE LOWER(CONCAT('%', :keyword, '%'))) AND " +
           "u.locked = false")
    Page<User> searchUsersWithUnBan(@Param("keyword") String keyword, @Param("gender") Gender gender, Pageable pageable);
    
    @Query("SELECT COUNT(u), FUNCTION('MONTH', u.createAt) FROM User u WHERE u.locked = false AND u.role <> 'Admin' AND FUNCTION('YEAR', u.createAt) = :year GROUP BY FUNCTION('MONTH', u.createAt)")
    List<Object[]> findUserCountByMonthAndYear(int year);
  
    @Query("SELECT DISTINCT FUNCTION('YEAR', u.createAt) FROM User u WHERE u.locked = false AND u.role <> 'Admin' ORDER BY FUNCTION('YEAR', u.createAt)")
    List<Integer> findYearsWithUsers();
    
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
}
