/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.Repository;

import com.Admin.DemoAdmin.Entity.Report;
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
public interface ReportRepository extends JpaRepository<Report, Integer> {
    @Query("select r from Report r where r.reportId LIKE %?1% or c.description LIKE %?1%  or c.reason LIKE %?1% or c.createDate LIKE %?1% or c.reportUser LIKE %?1% or c.reportedUser LIKE %?1%")
    Page<Report> searchCategories(String keyword, Pageable pageable);
}

