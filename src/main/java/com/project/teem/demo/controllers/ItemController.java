package com.project.teem.demo.controllers;


import com.project.teem.demo.models.Category;
import com.project.teem.demo.models.Item;
import com.project.teem.demo.service.CategoryService;
import com.project.teem.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ItemController {


    @Autowired
    private ItemService itemService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/admin/item")
    public String categoryPage(Model model){
        model.addAttribute("item", itemService.getAllItems());
        model.addAttribute("category", categoryService.getAllCategory());
        return "admin/admin_item";
    }

    @GetMapping("/admin/item/add")
    public String categoryAdd(Model model){
        List<Category> category = categoryService.getAllCategory();
        Item item = new Item();
        model.addAttribute("category", category);
        model.addAttribute("item", item);
        return "admin/add_item";
    }

    @PostMapping("/admin/item/add")
    public String addCategory(@ModelAttribute("item") Item item){
        itemService.saveItem(item);
        return "redirect:/admin/item";
    }
}
