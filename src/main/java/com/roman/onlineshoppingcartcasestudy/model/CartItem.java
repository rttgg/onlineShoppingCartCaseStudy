package com.roman.onlineshoppingcartcasestudy.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;


@Getter
@Setter
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "cartItem")
@Entity
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    int quantity;

    @ManyToOne
    @JoinColumn(name = "product_Id")
    Product product;

    @ManyToOne
    @JoinColumn(name = "user_Id", referencedColumnName = "ID")
    UserAccount userAccount;

    public CartItem() {
    }

    public CartItem(int quantity, Product product, UserAccount userAccount) {
        super();
        this.quantity = quantity;
        this.product = product;
        this.userAccount = userAccount;
    }

    public CartItem(Integer id, int quantity, Product product, UserAccount userAccount) {
        super();
        this.id = id;
        this.quantity = quantity;
        this.product = product;
        this.userAccount = userAccount;
    }
}
