package com.roman.onlineshoppingcartcasestudy.controller;

import com.roman.onlineshoppingcartcasestudy.services.CartService;
import com.roman.onlineshoppingcartcasestudy.services.CategoryService;
import com.roman.onlineshoppingcartcasestudy.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ShopController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        model.addAttribute("cartCount", CartService.shoppingCart.size());
        return "home";
    }

    @GetMapping("/shop")
    public String shop(Model model) {
        model.addAttribute("categories", categoryService.findAllCategory());
        model.addAttribute("products", productService.findAllProduct());
        model.addAttribute("cartCount", CartService.shoppingCart.size());
        return "shop";
    }

    @GetMapping("/shop/category/{id}")
    public String shopByCategory(Model model, @PathVariable int id) {
        model.addAttribute("categories", categoryService.findAllCategory());
        model.addAttribute("products", productService.findAllProductsByCategoryId(id));
        model.addAttribute("cartCount", CartService.shoppingCart.size());
        return "shop";
    }

    @GetMapping("/shop/viewproduct/{id}")
    public String viewProduct(Model model, @PathVariable int id) {
        model.addAttribute("product", productService.getProductById(id).get());
        model.addAttribute("cartCount", CartService.shoppingCart.size());
        return "viewproducts";
    }

    @GetMapping("/home/aboutus")
    public String about() {
        return "aboutus";
    }
}
