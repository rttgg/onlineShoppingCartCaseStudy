package com.roman.onlineshoppingcartcasestudy.services;

import com.roman.onlineshoppingcartcasestudy.model.CartItem;
import com.roman.onlineshoppingcartcasestudy.model.Category;
import com.roman.onlineshoppingcartcasestudy.model.Product;
import com.roman.onlineshoppingcartcasestudy.model.UserAccount;
import com.roman.onlineshoppingcartcasestudy.repository.CartItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class CartService {
    @Autowired
    private CartItemRepo cartItemRepo;

    public static List<Product> shoppingCart;

    static {
        shoppingCart = new ArrayList<Product>();
    }

//    public Optional<CartItem> findCartItemById(int id) {
//        return cartItemRepo.findById(id);
//    }

    public List<CartItem> listCartItem(UserAccount userAccount) {
        return cartItemRepo.findByUserAccount(userAccount);
    }

}
