/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.Repository;

import com.Admin.DemoAdmin.Entity.ProfileCategories;
import com.Admin.DemoAdmin.Entity.ProfileCategoryKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DAO
 */
@Repository
public interface ProfileCategoriesRepository extends JpaRepository<ProfileCategories, ProfileCategoryKey> {}
