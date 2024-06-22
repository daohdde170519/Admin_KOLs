/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.Controller;

import com.Admin.DemoAdmin.DTOs.ProfileFilterDTO;
import com.Admin.DemoAdmin.Entity.Category;
import com.Admin.DemoAdmin.Entity.Profile;
import com.Admin.DemoAdmin.Service.CategoryService;
import com.Admin.DemoAdmin.Service.ProfileService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author DAO
 */
@Controller
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private CategoryService categoryService;

    // Phương thức GET để hiển thị form lọc
    @GetMapping
    public String showFilterForm(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("filter", new ProfileFilterDTO()); // Đối tượng để binding với form
        return "filter_profiles";
    }

    // Phương thức POST để xử lý form lọc
    @PostMapping
    public String filterProfiles(
            @ModelAttribute("filter") ProfileFilterDTO filterDTO,
            Model model) {

        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);

        // Nếu location rỗng (empty) thì set location thành null để lấy tất cả các location
        if (filterDTO.getLocation() != null && filterDTO.getLocation().isEmpty()) {
            filterDTO.setLocation(null);
        }

        // Nếu categoryName rỗng (empty) thì set categoryName thành null để lấy tất cả các categoryName
        if (filterDTO.getCategoryName() != null && filterDTO.getCategoryName().isEmpty()) {
            filterDTO.setCategoryName(null);
        }

        List<Profile> profiles = profileService.findByFilters(
                filterDTO.getAverageRating(),
                filterDTO.getFullName(),
                filterDTO.getUsername(),
                filterDTO.getLocation(),
                filterDTO.getPriceAPost(),
                filterDTO.getPriceAToHireADay(),
                filterDTO.getPriceAVideo(),
                filterDTO.getRepresentativePrice(),
                filterDTO.getCategoryName()
        );
        profileService.setCategoryNamesForProfiles(profiles);
        
        model.addAttribute("profiles", profiles);

        // Trả về view để hiển thị kết quả
        return "filter_profiles";
    }
}
//@Controller
//public class ProfileController {
//
//    @Autowired
//    private ProfileService profileService;
//
//    @Autowired
//    private CategoryService categoryService;
//
//    @GetMapping("/profiles")
//    public String filterProfiles(@RequestParam(name = "averageRating", required = false) Double averageRating,
//            @RequestParam(name = "fullName", required = false) String fullName,
//            @RequestParam(name = "username", required = false) String username,
//            @RequestParam(name = "location", required = false) String location,
//            @RequestParam(name = "priceAPost", required = false) Long priceAPost,
//            @RequestParam(name = "priceAToHireADay", required = false) Long priceAToHireADay,
//            @RequestParam(name = "priceAVideo", required = false) Long priceAVideo,
//            @RequestParam(name = "representativePrice", required = false) Long representativePrice,
//            @RequestParam(name = "categoryName", required = false) String categoryName,
//            Model model) {
//
//        // Lọc ra các tham số có giá trị khác null hoặc rỗng
//        List<Profile> profiles = profileService.findByFilters(averageRating, fullName, username,
//                location, priceAPost, priceAToHireADay,
//                priceAVideo, representativePrice,
//                categoryName);
//
//        List<Category> categories = categoryService.getAllCategories();
//        
//        model.addAttribute("profiles", profiles);
//        model.addAttribute("categories", categories);
//        return "filter_profiles";
//    }
//
//}
