package com.roman.onlineshoppingcartcasestudy.services;

import com.roman.onlineshoppingcartcasestudy.model.Product;

import java.util.ArrayList;
import java.util.List;

public class CartService {
    public static List<Product> shoppingCart;

    static {
        shoppingCart = new ArrayList<Product>();
    }

}
