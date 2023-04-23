package com.project.teem.demo.controllers;

import com.project.teem.demo.models.Category;
import com.project.teem.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public String categoryPage(Model model){
        model.addAttribute("category", categoryService.getAllCategory());
        return "admin/admin_category";
    }

    @GetMapping("/category/add")
    public String categoryAdd(Model model){
        Category category = new Category();
        model.addAttribute("category", category);
        return "admin/add_category";
    }

    @PostMapping("/category/add")
    public String addCategory(@ModelAttribute("category") Category category){
        categoryService.saveCategory(category);
        return "redirect:/admin/category";
    }

    @GetMapping("/category/view/{id}")
    public String viewCategory(@PathVariable("id") Long id, Model model){
        Category categoryById = categoryService.getCategoryById(id);
        model.addAttribute("category", categoryById);
        return "admin/view_category";
    }

    @PostMapping("/category/view/{id}")
    public String updateCategory(@PathVariable("id") Long id, @ModelAttribute("category") Category category){
        Category existedCategory = categoryService.getCategoryById(id);
        existedCategory.setId(id);
        existedCategory.setName(category.getName());
        categoryService.updateCategory(existedCategory);
        return "redirect:/admin/category";
    }

    @GetMapping("/category/{id}")
    public String deleteCategory(@PathVariable("id") Long id){
        categoryService.deleteCategory(id);
        return "redirect:/admin/category";
    }
}
