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
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Profile")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Profile {
    @Id
    @Column(name = "user_id")
    private int profileId;

    @Column(name = "full_name", length = 100, columnDefinition = "NVARCHAR(MAX)")
    private String fullName;

    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String bio;

    @Column(name = "avatar_url", length = 500)
    private String avatarUrl;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "phonenumber", length = 15)
    private String phoneNumber;

    @Column(length = 50, columnDefinition = "NVARCHAR(MAX)")
    private String address;

    @Column(length = 50,columnDefinition = "NVARCHAR(MAX)")
    private String location;

    @Column(name = "priceAPost", nullable = false)
    private long priceAPost;

    @Column(name = "priceAVideo", nullable = false)
    private long priceAVideo;

    @Column(name = "priceAToHireADay", nullable = false)
    private long priceAToHireADay;

    @Column(name = "representativePrice", nullable = false)
    private long representativePrice;

    @Column(name = "rating")
    private double averageRating;

    @Column(name = "money")
    private double money;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;
    
    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    private List<Rating> ratings;

    public double computeAverageRating() {
        if (ratings == null || ratings.isEmpty()) {
            return 0.0;
        }
        double total = 0;
        for (Rating rating : ratings) {
            total += rating.getRatingValue();
        }
        return total / ratings.size();
    }
    
    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
        this.averageRating = computeAverageRating();
    }
    // Getters and setters

    @Transient
    private List<String> categoryNames; 

    public void setCategoryNames(List<String> categoryNames) {
        this.categoryNames = categoryNames;
    }

}