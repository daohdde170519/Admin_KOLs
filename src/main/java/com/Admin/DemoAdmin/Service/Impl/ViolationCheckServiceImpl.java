/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.Service.Impl;

/**
 *
 * @author DAO
 */
import com.Admin.DemoAdmin.Entity.Comment;
import com.Admin.DemoAdmin.Entity.CommentViolation;
import com.Admin.DemoAdmin.Entity.User;
import com.Admin.DemoAdmin.Entity.ViolationWord;
import com.Admin.DemoAdmin.Repository.CommentRepository;
import com.Admin.DemoAdmin.Repository.CommentViolationRepository;
import com.Admin.DemoAdmin.Repository.UserRepository;
import com.Admin.DemoAdmin.Repository.ViolationWordRepository;
import com.Admin.DemoAdmin.Service.UserNotificationService;
import com.Admin.DemoAdmin.Service.ViolationCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.ui.Model;

@Service
public class ViolationCheckServiceImpl implements ViolationCheckService {

    @Autowired
    private ViolationWordRepository violationWordRepository;

    @Autowired
    private CommentViolationRepository commentViolationRepository;
    
    @Autowired
    private CommentRepository commentRepository;
    
    @Autowired
    private UserNotificationService userNotificationService;
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public int checkCommentForViolations(Comment comment) {
        List<ViolationWord> violationWords = violationWordRepository.findAll();
        int highestViolationLevel = 0;

        for (ViolationWord violationWord : violationWords) {
            if (comment.getCommentContent().toLowerCase().contains(violationWord.getWord().toLowerCase())) {
                highestViolationLevel = Math.max(highestViolationLevel, violationWord.getViolationLevel());

                CommentViolation commentViolation = new CommentViolation();
                commentViolation.setComment(comment);
                commentViolation.setViolationWord(violationWord);               
                commentViolationRepository.save(commentViolation);
            }
        }

        return highestViolationLevel;
    }
    
        @Override
    public void handleViolation(Comment reportedComment, int violationLevel, Model model) {
        reportedComment.setIsViolation(true);
        commentRepository.save(reportedComment);

        User reportedUser = reportedComment.getCommenter();

        switch (violationLevel) {
            case 1:
                // Send a warning to the user
                userNotificationService.sendViolationNotification(reportedUser, violationLevel);
                model.addAttribute("message", "Comment contains violating words and user has been warned.");
                break;
            case 2:
                // Temporarily lock the account
                reportedUser.setLocked(true);
                userRepository.save(reportedUser);
                userNotificationService.sendViolationNotification(reportedUser, violationLevel);
                model.addAttribute("message", "Comment contains violating words and user account has been temporarily locked.");
                break;
            default:
                model.addAttribute("message", "Unknown violation level.");
        }
    }
}
