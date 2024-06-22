/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.DTOs;

/**
 *
 * @author DAO
 */
public class ProfileRatingDTO {
    private Integer profileId;
    private Double averageRating;

    public ProfileRatingDTO(Integer profileId, Double averageRating) {
        this.profileId = profileId;
        this.averageRating = averageRating;
    }

    // Getters and setters
    public Integer getProfileId() {
        return profileId;
    }

    public void setProfileId(Integer profileId) {
        this.profileId = profileId;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }
}
