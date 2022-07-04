package com.roman.onlineshoppingcartcasestudy.repository;

import com.roman.onlineshoppingcartcasestudy.model.CartItem;

import com.roman.onlineshoppingcartcasestudy.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepo extends JpaRepository<CartItem, Integer> {
    List<CartItem> findByUserAccount(UserAccount userAccount);

}
