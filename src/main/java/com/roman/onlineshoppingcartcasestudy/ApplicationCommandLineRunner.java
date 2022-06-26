package com.roman.onlineshoppingcartcasestudy;

import com.roman.onlineshoppingcartcasestudy.model.Category;
import com.roman.onlineshoppingcartcasestudy.model.Product;
import com.roman.onlineshoppingcartcasestudy.services.CategoryService;
import com.roman.onlineshoppingcartcasestudy.services.ProductService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
@Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ApplicationCommandLineRunner implements CommandLineRunner {

    CategoryService categoryService;
    ProductService productService;

    @Autowired
    public ApplicationCommandLineRunner(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @PostConstruct
    public void postConstruct(){
        log.warn("========Application CommandLine Runner=========");
    }

    @Override
    public void run(String... args) throws Exception {

        categoryService.saveOrUpdate(new Category("Calf Compression"));
        categoryService.saveOrUpdate(new Category("Elbow Compression"));
        categoryService.saveOrUpdate(new Category("Ankle Compression"));
        categoryService.saveOrUpdate(new Category("tight Compression"));


        productService.saveOrUpdate(new Product("sleeve", "sleeve footless compression", 14.99, "image"));
        productService.saveOrUpdate(new Product("foot", "socks compression", 14.99, "image"));
        productService.saveOrUpdate(new Product("hand", "fingerless compression", 14.99, "image"));
        productService.saveOrUpdate(new Product("hip", "sleeve footless compression", 14.99, "image"));
        productService.saveOrUpdate(new Product("finger", "compression for hand", 14.99, "image"));
        productService.saveOrUpdate(new Product("thick sleeve", "sleeve footless compression", 14.99, "image"));
        productService.saveOrUpdate(new Product("thin sleeve", "sleeve footless compression", 14.99, "image"));
        productService.saveOrUpdate(new Product("tight ", "sleeve footless compression", 14.99, "image"));






    }
//        productService.saveOrUpdate(new Product("aaa", "bbb", 3.14, Date.from(Instant.now())));
//        productService.saveOrUpdate(new Product("aaa", "bbb", 3.14, Date.from(Instant.now())));
//        productService.saveOrUpdate(new Product("aaa", "bbb", 3.14, Date.from(Instant.now())));
//        productService.saveOrUpdate(new Product("aaa", "bbb", 3.14, Date.from(Instant.now())));
//    }
}
