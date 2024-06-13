/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.Controller;

/**
 *
 * @author DAO
 */
import com.Admin.DemoAdmin.Entity.Category;
import com.Admin.DemoAdmin.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/admin/categories")
public class AdminCategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String listCategories(Model model, @RequestParam("page") Optional<Integer> page) {
        int currentPage = page.orElse(1);
        int pageSize = 10;
        Pageable pageable = PageRequest.of(currentPage - 1, pageSize);
        Page<Category> categoryPage = categoryService.findPaginated(pageable);

        model.addAttribute("categoryPage", categoryPage);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", categoryPage.getTotalPages());

        return "admin/category/listcategories";
    }
    
    
    @GetMapping("/search")
    public String searchCategories(@RequestParam("keyword") String keyword,
            @RequestParam("page") Optional<Integer> page,
            Model model) {
        int currentPage = page.orElse(1);
        int pageSize = 10;
        Pageable pageable = PageRequest.of(currentPage - 1, pageSize);
        Page<Category> categoryPage = categoryService.searchCategories(keyword, pageable);

        model.addAttribute("categoryPage", categoryPage);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", categoryPage.getTotalPages());
        model.addAttribute("keyword", keyword);

        return "admin/category/search_categoríes";
    }

    @GetMapping("/new")
    public String showNewCategoryForm(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "admin/category/newcategory";
    }

    @PostMapping
    public String saveCategory(@ModelAttribute("category") Category category, Model model) {
        boolean isDuplicate = categoryService.checkDuplicateCategory(category);

        if (isDuplicate) {
            model.addAttribute("duplicateMessage", "Category with the same name already exists!");
            return "admin/category/newcategory"; 
        }

        categoryService.saveCategory(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/edit/{id}")
    public String showEditCategoryForm(@PathVariable("id") int id, Model model) {
        Optional<Category> category = categoryService.getCategoryById(id);
        if (category.isPresent()) {
            model.addAttribute("category", category.get());
            return "admin/category/editcategory";
        } else {
            return "redirect:/admin/categories";
        }
    }

    @PostMapping("/update/{id}")
    public String updateCategory(@PathVariable("id") int id, @ModelAttribute("category") Category category, Model model) {
        Optional<Category> existingCategory = categoryService.getCategoryById(id);
        if (existingCategory.isPresent()) {
            String existingCategoryName = existingCategory.get().getCategoryName();
            if (!existingCategoryName.equals(category.getCategoryName())) {
                boolean isDuplicate = categoryService.checkDuplicateCategory(category);
                if (isDuplicate) {
                    model.addAttribute("duplicateMessage", "Category with the same name already exists!");
                    model.addAttribute("category", existingCategory.get());
                    return "admin/category/editcategory"; 
                }
            }
            category.setCategoryId(id);
            categoryService.saveCategory(category);
            return "redirect:/admin/categories";
        } else {
            return "redirect:/admin/categories";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") int id) {
        categoryService.deleteCategoryById(id);
        return "redirect:/admin/categories";
    }
}
