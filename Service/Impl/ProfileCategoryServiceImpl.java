/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.Service.Impl;

import com.Admin.DemoAdmin.DTOs.CategoryCountDTO;
import com.Admin.DemoAdmin.Repository.ProfileCategoriesRepository;
import com.Admin.DemoAdmin.Service.ProfileCategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DAO
 */
@Service
public class ProfileCategoryServiceImpl implements ProfileCategoryService{
    @Autowired
    private ProfileCategoriesRepository profileCategoryRepository;

    @Override
    public List<CategoryCountDTO> getCategoryCounts() {
        return profileCategoryRepository.findCategoryCounts();
    }


}
