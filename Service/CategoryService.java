/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.Service;

/**
 *
 * @author DAO
 */
import com.Admin.DemoAdmin.Entity.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {
    List<Category> getAllCategories();
    Optional<Category> getCategoryById(int id);
    Category saveCategory(Category category);
    void deleteCategoryById(int id);
    Page<Category> findPaginated(Pageable pageable);
    Page<Category> searchCategories(String keyword, Pageable pageable);
    boolean checkDuplicateCategory(Category category);
}

