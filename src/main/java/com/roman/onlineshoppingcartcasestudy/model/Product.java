package com.roman.onlineshoppingcartcasestudy.model;

import javax.persistence.*;

@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String productDescription;
    private double price;
    private String image;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_Id", referencedColumnName = "category_id")
    private Category category;

    public Product() {
    }

    public Product(String name, String productDescription, double price, String image, Category category) {
        this.name = name;
        this.productDescription = productDescription;
        this.price = price;
        this.image = image;
        this.category = category;
    }

    public Product(Long id, String name, String productDescription, double price, String image, Category category) {
        this.id = id;
        this.name = name;
        this.productDescription = productDescription;
        this.price = price;
        this.image = image;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", category=" + category +
                '}';
    }
}
