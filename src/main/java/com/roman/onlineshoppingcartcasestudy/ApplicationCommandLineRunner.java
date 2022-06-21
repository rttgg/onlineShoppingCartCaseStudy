package com.roman.onlineshoppingcartcasestudy;

import com.roman.onlineshoppingcartcasestudy.services.ProductService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
@Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ApplicationCommandLineRunner implements CommandLineRunner {

    ProductService productService;
    @Autowired
    public ApplicationCommandLineRunner(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {
//        productService.saveOrUpdate(new Product("aaa", "bbb", 3.14, Date.from(Instant.now())));
//        productService.saveOrUpdate(new Product("aaa", "bbb", 3.14, Date.from(Instant.now())));
//        productService.saveOrUpdate(new Product("aaa", "bbb", 3.14, Date.from(Instant.now())));
//        productService.saveOrUpdate(new Product("aaa", "bbb", 3.14, Date.from(Instant.now())));
    }
}
