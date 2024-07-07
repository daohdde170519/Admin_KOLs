/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.Controller;

import com.Admin.DemoAdmin.Entity.Category;
import com.Admin.DemoAdmin.Entity.KolRegistration;
import com.Admin.DemoAdmin.Service.CategoryService;
import com.Admin.DemoAdmin.Service.KolRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/guest")
public class KolRegistrationController {

    @Autowired
    private KolRegistrationService kolRegistrationService;

    @Autowired
    private CategoryService categoryService;

    private static String UPLOAD_DIR;

    @Value("${upload.dir}")
    public void setUploadDir(String uploadDir) {
        UPLOAD_DIR = uploadDir;
    }

    @PostConstruct
    public void init() {
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("kolRegistration", new KolRegistration());
        model.addAttribute("categories", categories);
        return "registerKol";
    }

    @PostMapping("/register")
    public String registerKol(@ModelAttribute KolRegistration kolRegistration, @RequestParam("images") MultipartFile[] images, @RequestParam("categories") List<String> categories, RedirectAttributes redirectAttributes) {
        String imageUrls = "";
        for (MultipartFile image : images) {
            if (!image.isEmpty()) {
                try {
                    byte[] bytes = image.getBytes();
                    Path path = Paths.get(UPLOAD_DIR + File.separator + image.getOriginalFilename());
                    Files.write(path, bytes);

                    if (!imageUrls.isEmpty()) {
                        imageUrls += ",";
                    }
                    imageUrls += path.toString();
                } catch (IOException e) {
                    e.printStackTrace();
                    // Log the exception
                    System.out.println("Error: " + e.getMessage());
                    redirectAttributes.addFlashAttribute("message", "Failed to upload the file: " + e.getMessage());
                    return "redirect:/guest/register";
                }
            }
        }
        kolRegistration.setImageUrls(imageUrls);

        kolRegistration.setCategories(String.join(",", categories));

        kolRegistrationService.saveRegistration(kolRegistration);

        redirectAttributes.addFlashAttribute("message", "Registration successful");
        return "redirect:/guest/register";
    }
}