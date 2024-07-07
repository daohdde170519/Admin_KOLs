/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.Service.Impl;

/**
 *
 * @author DAO
 */
import com.Admin.DemoAdmin.Entity.Category;
import com.Admin.DemoAdmin.Repository.CategoryRepository;
import com.Admin.DemoAdmin.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getCategoryById(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategoryById(int id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Page<Category> findPaginated(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Page<Category> searchCategories(String keyword, Pageable pageable) {
       return categoryRepository.searchCategories(keyword, pageable);
    }
    
    @Override
    public boolean checkDuplicateCategory(Category category) {
        List<Category> existingCategories = categoryRepository.findAll();

        for (Category existingCategory : existingCategories) {
            if (existingCategory.getCategoryName().equalsIgnoreCase(category.getCategoryName())) {
                return true;
            }
        }
        return false;
    }
}

