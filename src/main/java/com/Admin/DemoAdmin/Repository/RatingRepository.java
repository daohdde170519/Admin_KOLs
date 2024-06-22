/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.Repository;

import com.Admin.DemoAdmin.DTOs.ProfileRatingDTO;
import com.Admin.DemoAdmin.Entity.Rating;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DAO
 */
@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {

    @Query("SELECT ra.ratingValue " +
           "FROM Rating ra " +
           "JOIN ra.profile p " +
           "JOIN p.user u " +
           "WHERE u.userId = :requesterId")
    List<Integer> findRatingValuesByRequesterId(@Param("requesterId") Integer requesterId);
}

