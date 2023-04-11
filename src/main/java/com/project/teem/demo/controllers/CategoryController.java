package com.project.teem.demo.controllers;

import com.project.teem.demo.models.Category;
import com.project.teem.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/admin/category")
    public String categoryPage(Model model){
        model.addAttribute("category", categoryService.getAllCategory());
        return "admin/admin_category";
    }

    @GetMapping("/admin/category/add")
    public String categoryAdd(Model model){
        Category category = new Category();
        model.addAttribute("category", category);
        return "admin/add_category";
    }

    @PostMapping("/admin/category/add")
    public String addCategory(@ModelAttribute("category") Category category){
        categoryService.saveCategory(category);
        return "admin/admin_category";
    }
}
