package com.Admin.DemoAdmin.Controller;

import com.Admin.DemoAdmin.DTOs.UserDTO;
import com.Admin.DemoAdmin.DTOs.ProfileDTO;
import com.Admin.DemoAdmin.Entity.User;
import com.Admin.DemoAdmin.Service.UserService;
import com.Admin.DemoAdmin.Service.ProfileService;
import com.Admin.DemoAdmin.Mapper.ProfileMapper;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminListUsersController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private ProfileMapper profileMapper;
    
    
    // Hiển thị Danh sách theo phân trang
    @GetMapping("/list_users")
    public String listUsers(Model model, @RequestParam("page") Optional<Integer> page) {
        int currentPage = page.orElse(1);
        int pageSize = 10;

        Page<UserDTO> userPage = userService.findPaginated(PageRequest.of(currentPage - 1, pageSize));

        model.addAttribute("userPage", userPage);
        model.addAttribute("users", userPage.getContent());
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", userPage.getTotalPages());

        return "users/listusers";
    }
    
    //Hiển thị thông tin search theo phân trang
    @GetMapping("/search-result")
    public String searchUsers(@RequestParam("keyword") String keyword, Model model, @RequestParam("page") Optional<Integer> page) {
        int currentPage = page.orElse(1);
        int pageSize = 10;

        Page<UserDTO> userPage = userService.searchUsers(keyword, PageRequest.of(currentPage - 1, pageSize));

        model.addAttribute("userPage", userPage);
        model.addAttribute("users", userPage.getContent());
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", userPage.getTotalPages());
        model.addAttribute("keyword", keyword);

        return "users/searchresult"; 
    }

    
    // BanAction
    @PostMapping("/users/ban/{id}")
    public ResponseEntity<String> banUser(@PathVariable Integer id) {
        User user = userService.findById(id);
        if (user != null) {
            if (!user.isLocked()) {
                user.setLocked(true); // Set locked status to true
                userService.save(user);
                return ResponseEntity.ok("User with ID " + id + " has been banned.");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User is already banned.");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
    }

    @PostMapping("/users/unban/{id}")
    public ResponseEntity<String> unbanUser(@PathVariable Integer id) {
        User user = userService.findById(id);
        if (user != null) {
            if (user.isLocked()) {
                user.setLocked(false); // Set locked status to false
                userService.save(user);
                return ResponseEntity.ok("User with ID " + id + " has been unbanned.");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User is not banned.");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
    }


    // ViewAction
    @GetMapping("/users/view/{id}")
    public String viewUserProfile(@PathVariable Integer id, @RequestParam("page") Optional<Integer> page, Model model) {
        UserDTO userDTO = userService.getUserDTOById(id);
        ProfileDTO profileDTO = profileService.getUserProfile(id);
        int currentPage = page.orElse(1); // Lấy trang hiện tại từ tham số request (nếu có)

        if (userDTO != null && profileDTO != null) {
            model.addAttribute("profile", profileDTO);
            model.addAttribute("currentPage", currentPage); // Thêm currentPage vào model
            return "/users/profile";
        } else {
            return "profile";
        }
    }
}



//    @GetMapping("/list_users/{pageNo}")
//    public String usersPage(@PathVariable("page") int pageNo, Model model){
//        Page<User> users = userService.pageUsers(pageNo);
//     model.addAttribute("users", users);
//     model.addAttribute("Title", users.getContent());
//        model.addAttribute("currentPage", pageNo);
//        model.addAttribute("size", users.getSize());
//       model.addAttribute("totalPages", users.getTotalPages());
//        return "listusers";
//  }


//    @PostMapping("/users/delete/{id}")
//    public String deleteUser(@PathVariable Integer id) {
//        userService.deleteUserById(id);
//        return "redirect:/admin/list_users";
//    }