package com.roman.onlineshoppingcartcasestudy.controller;

import com.roman.onlineshoppingcartcasestudy.model.UserAccount;
import com.roman.onlineshoppingcartcasestudy.services.ShoppingCartServices;
import com.roman.onlineshoppingcartcasestudy.security.AppUserAccountDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShoppingCartController {


    @Autowired
    private AppUserAccountDetailsService appUserAccountDetailsService;
    @Autowired
    private ShoppingCartServices shoppingCartServices;


    @GetMapping("/cart")
    public String showShoppingCart(Model model) {

//        List<CartItem> cartItems = shoppingCartServices.allCartItems();
        model.addAttribute("cartItems", shoppingCartServices.allCartItems(new UserAccount()));
        model.addAttribute("pageTitle", "Shopping Cart");

        return "shoppingCart";

    }

}
