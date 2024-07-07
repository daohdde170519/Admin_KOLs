/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.Service.Impl;

import com.Admin.DemoAdmin.Entity.Comment;
import com.Admin.DemoAdmin.Entity.Report;
import com.Admin.DemoAdmin.Repository.CommentRepository;
import com.Admin.DemoAdmin.Repository.ReportRepository;
import com.Admin.DemoAdmin.Service.ReportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author DAO
 */
@Service
public class ReportServiceImpl implements ReportService{
    @Autowired
    private ReportRepository reportRepository;
    
    @Autowired
    private CommentRepository commentRepository;
    @Override
    public Page<Report> findPaginated(Pageable pageable) {
      return  reportRepository.findAll(pageable);
    }

    @Override
    public Page<Report> searchCategories(String keyword, Pageable pageable) {
        return  reportRepository.searchReports(keyword, pageable);
    }
    
    @Override
    public void deleteReportById(int reportId) {
        if (reportRepository.existsById(reportId)) {
            reportRepository.deleteById(reportId);
        }
    }

    @Override
    public void saveReport(Report report) {
        // Ensure the comment is saved first
        Comment comment = report.getReportedComment();
        if (comment != null && comment.getCommentId() == null) {
            commentRepository.save(comment);
        }
        // Now save the report
        reportRepository.save(report);
      }
}
