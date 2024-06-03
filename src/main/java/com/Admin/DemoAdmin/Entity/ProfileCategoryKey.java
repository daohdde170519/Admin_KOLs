/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.Entity;

/**
 *
 * @author DAO
 */
import java.io.Serializable;
import java.util.Objects;

public class ProfileCategoryKey implements Serializable {
    private int userId;
    private int categoryId;

    public ProfileCategoryKey() {}

    public ProfileCategoryKey(int userId, int categoryId) {
        this.userId = userId;
        this.categoryId = categoryId;
    }

    // Getters and setters

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfileCategoryKey that = (ProfileCategoryKey) o;
        return userId == that.userId && categoryId == that.categoryId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, categoryId);
    }
}


