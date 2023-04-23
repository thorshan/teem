package com.project.teem.demo.controllers;


import com.project.teem.demo.dto.ItemDto;
import com.project.teem.demo.models.Category;
import com.project.teem.demo.models.Item;
import com.project.teem.demo.repository.ItemRepository;
import com.project.teem.demo.service.CategoryService;
import com.project.teem.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class ItemController {


    @Autowired
    private ItemService itemService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/item")
    public String itemPage(Model model){
        model.addAttribute("item", itemService.getAllItems());
        model.addAttribute("category", categoryService.getAllCategory());
        return "admin/admin_item";
    }

    @GetMapping("/item/add")
    public String itemAddGet(Model model){
        List<Category> category = categoryService.getAllCategory();
        ItemDto item = new ItemDto();
        model.addAttribute("category", category);
        model.addAttribute("item", item);
        return "admin/add_item";
    }

    @PostMapping("/item/add")
    public String itemAddPost(@ModelAttribute("item")ItemDto itemDto) throws IOException {
        itemService.saveItem(itemDto);
        return "redirect:/admin/item";
    }

    @GetMapping("/item/view/{id}")
    public String updateItemGet(@PathVariable("id")Long id, Model model){
        Item item = itemService.getItemById(id);
        model.addAttribute("item", item);
        model.addAttribute("category", categoryService.getAllCategory());
        return "admin/view_item";
    }

    @PostMapping("/item/view/{id}")
    public String updateItemPost(@ModelAttribute("item")ItemDto itemDto) throws IOException {

        itemService.updateItem(itemDto);
        return "redirect:/admin/item";
    }

    @GetMapping("/item/{id}")
    public String deleteItem(@PathVariable("id") Long id){
        itemService.deleteItem(id);
        return "redirect:/admin/item";
    }

}
