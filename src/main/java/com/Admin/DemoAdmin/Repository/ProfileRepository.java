/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.Repository;

import com.Admin.DemoAdmin.Entity.Profile;
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
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    @Query("SELECT DISTINCT p FROM Profile p "
            + "JOIN p.user u "
            + "LEFT JOIN ProfileCategories pc ON p.profileId = pc.userId "
            + "LEFT JOIN Category c ON pc.categoryId = c.categoryId "
            + "WHERE (:averageRating IS NULL OR p.averageRating >= :averageRating) "
            + "AND u.locked = false " 
            + "AND u.role = 'KOL' " 
            + "AND (:fullName IS NULL OR p.fullName LIKE %:fullName%) "
            + "AND (:username IS NULL OR u.username LIKE %:username%) "
            + "AND (:location IS NULL OR p.location = :location) "
            + "AND (:priceAPost IS NULL OR p.priceAPost <= :priceAPost) "
            + "AND (:priceAToHireADay IS NULL OR p.priceAToHireADay <= :priceAToHireADay) "
            + "AND (:priceAVideo IS NULL OR p.priceAVideo <= :priceAVideo) "
            + "AND (:representativePrice IS NULL OR p.representativePrice <= :representativePrice) "
            + "AND (:categoryName IS NULL OR c.categoryName = :categoryName)")
    List<Profile> findByFilters(@Param("averageRating") Double averageRating,
                                @Param("fullName") String fullName,
                                @Param("username") String username,
                                @Param("location") String location,
                                @Param("priceAPost") Long priceAPost,
                                @Param("priceAToHireADay") Long priceAToHireADay,
                                @Param("priceAVideo") Long priceAVideo,
                                @Param("representativePrice") Long representativePrice,
                                @Param("categoryName") String categoryName);
    
    
    @Query("SELECT DISTINCT pc.category.categoryName FROM Profile p "
            + "JOIN p.user u "
            + "LEFT JOIN ProfileCategories pc ON p.profileId = pc.userId "
            + "LEFT JOIN Category c ON pc.categoryId = c.categoryId "
            + "WHERE p.profileId = :profileId")
    List<String> findCategoryNamesByProfileId(@Param("profileId") int profileId);
}