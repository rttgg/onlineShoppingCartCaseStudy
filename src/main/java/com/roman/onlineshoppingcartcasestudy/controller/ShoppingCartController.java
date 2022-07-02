package com.roman.onlineshoppingcartcasestudy.controller;

import com.roman.onlineshoppingcartcasestudy.model.Product;
import com.roman.onlineshoppingcartcasestudy.services.CartService;
import com.roman.onlineshoppingcartcasestudy.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
@Controller
public class ShoppingCartController {

    @Autowired
    ProductService productService;


    @GetMapping("/addToCart/{id}")
    public String addProductToCart(@PathVariable int id) {
        CartService.shoppingCart.add(productService.getProductById(id).get());
        return "redirect:/shop";
    }

    @GetMapping("/cart")
    public String productInCart(Model model) {
        model.addAttribute("cartCount", CartService.shoppingCart.size());
        model.addAttribute("total", CartService.shoppingCart.stream().mapToDouble(Product::getPrice).sum());
        model.addAttribute("cart", CartService.shoppingCart);
        return "cart";
    }

//    @GetMapping("/cart/update")
//    public String updateProductInCart(@PathVariable int quantity, Model model) {
//        Optional<Product> product = CartService.shoppingCart.
//    }

    @GetMapping("/checkout")
    public String checkout(Model model) {
        model.addAttribute("total", CartService.shoppingCart.stream().mapToDouble(Product::getPrice).sum());
        return "checkout";
    }
}
