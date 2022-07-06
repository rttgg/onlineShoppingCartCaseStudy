package com.roman.onlineshoppingcartcasestudy.services;

import com.roman.onlineshoppingcartcasestudy.model.CartItem;
import com.roman.onlineshoppingcartcasestudy.model.Product;
import com.roman.onlineshoppingcartcasestudy.model.UserAccount;
import com.roman.onlineshoppingcartcasestudy.repository.CartItemRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CartService {
    @Autowired
    private CartItemRepo cartItemRepo;

    public static List<Product> shoppingCart;

    static {
        shoppingCart = new ArrayList<Product>();
    }

    public List<CartItem> listCartItem(UserAccount userAccount) {
        return cartItemRepo.findByUserAccount(userAccount);
    }

}
