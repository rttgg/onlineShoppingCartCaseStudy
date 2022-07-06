package com.roman.onlineshoppingcartcasestudy;

import com.roman.onlineshoppingcartcasestudy.model.Category;
import com.roman.onlineshoppingcartcasestudy.model.UserAccount;
import com.roman.onlineshoppingcartcasestudy.repository.UserAccountRepo;
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

        categoryService.saveOrUpdate(new Category("TRONS Calf Compression Socks"));
        categoryService.saveOrUpdate(new Category("TRONS Copper Compression Socks"));
        categoryService.saveOrUpdate(new Category("TRONS Thigh Compression Sleeves"));
        categoryService.saveOrUpdate(new Category("TRONS Arthritis Hand Compression"));

    }

}
