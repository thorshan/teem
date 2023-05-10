package com.project.teem.demo.controllers;

import com.project.teem.demo.service.CategoryService;
import com.project.teem.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ShopController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ItemService itemService;

    @GetMapping("/shop")
    public String shopPage(Model model){
        model.addAttribute("category", categoryService.getAllCategory());
        model.addAttribute("item", itemService.getAllItems());
        return "/public/shop";
    }

    @GetMapping("/shop/item/details/{id}")
    public String viewDetails(@PathVariable("id") Long id, Model model){
        model.addAttribute("category", categoryService.getAllCategory());
        model.addAttribute("item", itemService.getItemById(id));
        return "/public/view_item_details";
    }

    @GetMapping("/shop/cart/{id}")
    public String viewCart(@PathVariable("id") Long id, Model model){
        model.addAttribute("category", categoryService.getAllCategory());
        model.addAttribute("item", itemService.getItemById(id));
        return "/public/cart";
    }
}
