package com.roman.onlineshoppingcartcasestudy.controller;

import com.roman.onlineshoppingcartcasestudy.services.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/admin")
    public String adminPage() {
        return "adminPage";
    }

    @GetMapping("/admin/categories")
    public String getCategories(Model model) {
        model.addAttribute("categories", categoryService.getAllCategory());
        return "categories";
    }
}

