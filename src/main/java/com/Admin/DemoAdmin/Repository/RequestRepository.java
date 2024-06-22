/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.Repository;

import com.Admin.DemoAdmin.Entity.Request;
import com.Admin.DemoAdmin.Entity.User;
import java.util.Date;
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
public interface RequestRepository extends JpaRepository<Request, Integer> {

//    @Query("SELECT DISTINCT u " +
//           "FROM Request r " +
//           "JOIN User u ON r.requester.userId = u.userId " +
//           "LEFT JOIN RequestCategories rc ON r.requestId = rc.request.requestId " +
//           "LEFT JOIN Category c ON rc.category.categoryId = c.categoryId " +
//           "WHERE (:minPayment IS NULL OR r.payment >= :minPayment) " +
//           "AND (:maxPayment IS NULL OR r.payment <= :maxPayment) " +
//           "AND (:location IS NULL OR r.requestLocation = :location) " +
//           "AND (:startDate IS NULL OR r.requestDate >= :startDate) " +
//           "AND (:endDate IS NULL OR r.requestDateEnd <= :endDate) " +
//           "AND r.requestStatus = false " +
//           "AND r.request_type = false " +
//           "AND u.locked = false " +
//           "AND u.role = 'KOL' " +
//           "AND (:categoryId IS NULL OR c.categoryId = :categoryId) " +
//           "AND (:minRating IS NULL OR (SELECT AVG(ra.ratingValue) FROM Rating ra WHERE ra.profile.user.userId = u.userId) >= :minRating)")
//    List<User> findUsernamesByFilters(
//            @Param("minPayment") Double minPayment,
//            @Param("maxPayment") Double maxPayment,
//            @Param("location") String location,
//            @Param("startDate") Date startDate,
//            @Param("endDate") Date endDate,
//            @Param("categoryId") Integer categoryId,
//            @Param("minRating") Double minRating
//    );
}




