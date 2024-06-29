/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.Repository;

import com.Admin.DemoAdmin.Entity.Request;
import com.Admin.DemoAdmin.Entity.RequestStatus;
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
    @Query("SELECT r FROM Request r WHERE "
         + "(:requestTypes IS NULL OR r.requestType IN :requestTypes) AND "
         + "(:requestLocation IS NULL OR r.requestLocation = :requestLocation) AND "
         + "r.isPublic = true AND r.requestStatus = :requestStatus")
    List<Request> findFilteredRequests(
            @Param("requestTypes") List<String> requestTypes,
            @Param("requestLocation") String requestLocation,
            @Param("requestStatus") RequestStatus requestStatus
    );
}





