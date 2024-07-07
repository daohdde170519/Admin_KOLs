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
import com.Admin.DemoAdmin.Entity.Notification;
import com.Admin.DemoAdmin.Entity.TypeNotification;
import com.Admin.DemoAdmin.Entity.User;
import com.Admin.DemoAdmin.Entity.ViolationWord;
import com.Admin.DemoAdmin.Repository.CommentViolationRepository;
import com.Admin.DemoAdmin.Repository.ViolationWordRepository;
import com.Admin.DemoAdmin.Service.NotificationService;
import com.Admin.DemoAdmin.Service.UserService;
import com.Admin.DemoAdmin.Service.ViolationCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ViolationCheckServiceImpl implements ViolationCheckService {

    @Autowired
    private ViolationWordRepository violationWordRepository;

    @Autowired
    private CommentViolationRepository commentViolationRepository;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private UserService userService;


    @Override
    public void checkCommentForViolations(Comment comment) {
        List<ViolationWord> violationWords = violationWordRepository.findAll();
        for (ViolationWord word : violationWords) {
            if (comment.getCommentContent().contains(word.getWord())) {
                CommentViolation commentViolation = new CommentViolation();
                commentViolation.setComment(comment);
                commentViolation.setViolationWord(word);
                comment.setIsViolation(Boolean.TRUE);
                commentViolationRepository.save(commentViolation);

                if (word.getViolationLevel() == 1) {
                    Notification notification = new Notification();
                    notification.setType(TypeNotification.ACCOUNT);
                    notification.setContent("You have used a prohibited word in your comment.");
                    notification.setUser(comment.getCommenter());
                    notification.setReferenceId(null);
                    notificationService.createNotification(notification);
                } else if (word.getViolationLevel() == 2) {
                    User user = comment.getCommenter();
                    user.setLocked(true);
                    userService.save(user);
                }
            }
        }
    }
}
