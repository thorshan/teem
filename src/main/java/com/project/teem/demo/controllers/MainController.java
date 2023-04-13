package com.project.teem.demo.controllers;

import com.project.teem.demo.service.CategoryService;
import com.project.teem.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/index")
    public String homePage(){
        return "index";
    }

    @GetMapping("/admin/home")
    public String adminDashboard(Model model){
        model.addAttribute("categoryCount", categoryService.categoryCount());
        model.addAttribute("itemCount", itemService.itemCount());
        return "/admin/home";
    }
}
