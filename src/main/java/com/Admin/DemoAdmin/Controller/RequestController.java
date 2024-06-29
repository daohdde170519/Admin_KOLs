/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.Controller;

import com.Admin.DemoAdmin.DTOs.RequestFilterDTO;
import com.Admin.DemoAdmin.Entity.Category;
import com.Admin.DemoAdmin.Entity.Request;
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
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author DAO
 */
@Controller
public class RequestController {

    @Autowired
    private RequestService requestService;

    @GetMapping("/filtered-requests")
    public String getFilteredRequests(
            @RequestParam(required = false) List<String> requestTypes,
            @RequestParam(required = false) String requestLocation,
            Model model) {
        List<Request> requests = requestService.getFilteredRequests(requestTypes, requestLocation);
        model.addAttribute("requests", requests);
        return "filterRequests";
    }
}



