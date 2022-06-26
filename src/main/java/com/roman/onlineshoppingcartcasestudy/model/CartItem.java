package com.roman.onlineshoppingcartcasestudy.model;

import javax.persistence.*;

@Entity
@Table(name = "cart_item")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    @ManyToOne
    @JoinColumn(name = "product_Id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "userName")
    private Account account;
    private int quantity;

    public CartItem() {
    }

    public CartItem(
            Product product,
            Account account, int quantity) {
        this.product = product;
        this.account = account;
        this.quantity = quantity;
    }

    public CartItem(Integer id,
                    Product product,
                    Account account,
                    int quantity) {
        Id = id;
        this.product = product;
        this.account = account;
        this.quantity = quantity;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "Id=" + Id +
                ", product=" + product +
                ", account=" + account +
                ", quantity=" + quantity +
                '}';
    }
}
