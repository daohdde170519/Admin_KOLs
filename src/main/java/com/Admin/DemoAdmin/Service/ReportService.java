/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Admin.DemoAdmin.Service;

import com.Admin.DemoAdmin.Entity.Report;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author DAO
 */
@Service
public interface ReportService {
    Page<Report> findPaginated(Pageable pageable);
    Page<Report> searchCategories(String keyword, Pageable pageable);
    void deleteReportById(int reportId);
    void saveReport(Report report);
    List<Report> findByReportedUserId(int userId);
}
