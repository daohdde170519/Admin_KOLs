/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.Controller;

import com.Admin.DemoAdmin.DTOs.RequestFilterDTO;
import com.Admin.DemoAdmin.Entity.Category;
import com.Admin.DemoAdmin.Entity.User;
import com.Admin.DemoAdmin.Service.CategoryService;
import com.Admin.DemoAdmin.Service.RequestService;
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
@RequestMapping("/requests")
public class RequestController {
//
//    @Autowired
//    private RequestService requestService;
//
//    @Autowired
//    private CategoryService categoryService;
//
//    // Phương thức GET để hiển thị form lọc
//    @GetMapping("/filter")
//    public String showFilterForm(Model model) {
//        List<Category> categories = categoryService.getAllCategories();
//        model.addAttribute("categories", categories);
//        model.addAttribute("filter", new RequestFilterDTO()); // Đối tượng để binding với form
//        model.addAttribute("usernames", List.of()); // Khởi tạo list rỗng ban đầu
//        return "filterRequests";
//    }
//
//    // Phương thức POST để xử lý form lọc
//    @PostMapping("/filter")
//    public String filterRequests(
//            @ModelAttribute("filter") RequestFilterDTO filter,
//            Model model) {
//
//        List<Category> categories = categoryService.getAllCategories();
//        model.addAttribute("categories", categories);
//        
//        // Nếu location rỗng (empty) thì set location thành null để lấy tất cả các location
//        if (filter.getLocation() != null && filter.getLocation().isEmpty()) {
//            filter.setLocation(null);
//        }
//        // Lấy các thông tin từ đối tượng filter và gọi service để lấy usernames
//        List<User> user = requestService.getUsernamesByFilters(
//                filter.getMinPayment(),
//                filter.getMaxPayment(),
//                filter.getLocation(),
//                filter.getStartDate(),
//                filter.getEndDate(),
//                filter.getCategoryID(),
//                filter.getMinRating()
//        );
//
//        model.addAttribute("user", user);
//
//        // Trả về view để hiển thị kết quả
//        return "filterRequests";
//    }
}


