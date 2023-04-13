package com.project.teem.demo.controllers;

import com.project.teem.demo.models.Category;
import com.project.teem.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
        return "redirect:/admin/category";
    }

    @GetMapping("/admin/category/view/{id}")
    public String viewCategory(@PathVariable("id") Long id, Model model){
        Category categoryById = categoryService.getCategoryById(id);
        model.addAttribute("category", categoryById);
        return "admin/view_category";
    }

    @PostMapping("/admin/category/view/{id}")
    public String updateAndDelete(@PathVariable("id") Long id, @ModelAttribute("category") Category category){
        Category existedCategory = categoryService.getCategoryById(id);
        existedCategory.setId(id);
        existedCategory.setName(category.getName());
        categoryService.updateCategory(existedCategory);
        return "redirect:/admin/category";
    }

    @GetMapping("/admin/category/{id}")
    public String deleteCategory(@PathVariable("id") Long id){
        categoryService.deleteCategory(id);
        return "redirect:/admin/category";
    }
}
