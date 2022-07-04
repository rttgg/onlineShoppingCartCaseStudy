package com.roman.onlineshoppingcartcasestudy.repository;

import com.roman.onlineshoppingcartcasestudy.model.CartItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface CartItemRepo extends JpaRepository<CartItem, Integer> {
    CartItem findByUserAccount(String email);

}
