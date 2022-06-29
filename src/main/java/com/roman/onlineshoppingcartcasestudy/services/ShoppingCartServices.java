package com.roman.onlineshoppingcartcasestudy.services;

import com.roman.onlineshoppingcartcasestudy.model.CartItem;
import com.roman.onlineshoppingcartcasestudy.model.UserAccount;
import com.roman.onlineshoppingcartcasestudy.repository.CartItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServices {

    @Autowired
    private CartItemRepo cartItemRepo;

    public List<CartItem> allCartItems(UserAccount userAccount) {
        return cartItemRepo.findByUserAccount(userAccount);
    }
}
