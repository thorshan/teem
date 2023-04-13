package com.project.teem.demo.controllers;

import com.project.teem.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShopController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/shop")
    public String shopPage(Model model){
        model.addAttribute("category", categoryService.getAllCategory());
        return "/public/shop";
    }

    @GetMapping("/shop/item/details")
    public String viewDetails(){
        return "/public/view_item_details";
    }
}
