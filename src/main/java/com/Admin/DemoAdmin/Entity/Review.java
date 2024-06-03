/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.Entity;

/**
 *
 * @author DAO
 */
import jakarta.persistence.*;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Reviews")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rating_id")
    private int ratingId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rater_id")
    private User rater;

    @Column(name = "rating_value", nullable = false)
    private int ratingValue;

    @Column(name = "rating_comment", columnDefinition = "NVARCHAR(MAX)")
    private String ratingComment;

    @Column(name = "rating_date")
    private Date ratingDate;

    // Getters and setters
}


