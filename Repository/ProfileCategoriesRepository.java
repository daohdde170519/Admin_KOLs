/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.Repository;

import com.Admin.DemoAdmin.DTOs.CategoryCountDTO;
import com.Admin.DemoAdmin.Entity.ProfileCategories;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DAO
 */
@Repository
public interface ProfileCategoriesRepository extends JpaRepository<ProfileCategories, Integer> {
            @Query("SELECT new com.Admin.DemoAdmin.DTOs.CategoryCountDTO(c.categoryName, COUNT(pc)) " +
           "FROM ProfileCategories pc JOIN pc.category c " +
           "GROUP BY c.categoryName")
    List<CategoryCountDTO> findCategoryCounts();
}