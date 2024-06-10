/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Admin.DemoAdmin.Service;

import com.Admin.DemoAdmin.Entity.Comment;
import org.springframework.ui.Model;

/**
 *
 * @author DAO
 */
public interface ViolationCheckService {
    int checkCommentForViolations(Comment comment);
    void handleViolation(Comment reportedComment, int violationLevel, Model model);
}
