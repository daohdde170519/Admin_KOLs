/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Admin.DemoAdmin.Service;

import com.Admin.DemoAdmin.DTOs.CategoryCountDTO;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author DAO
 */
@Service
public interface ProfileCategoryService {
    List<CategoryCountDTO> getCategoryCounts();
}
