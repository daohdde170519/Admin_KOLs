/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.Repository;

import com.Admin.DemoAdmin.Entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DAO
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query("select c from Category c where c.categoryName LIKE %?1% or c.description LIKE %?1%")
    Page<Category> searchCategories(String keyword, Pageable pageable);
}