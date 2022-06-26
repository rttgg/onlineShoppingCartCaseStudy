package com.roman.onlineshoppingcartcasestudy.services;

import com.roman.onlineshoppingcartcasestudy.model.Category;
import com.roman.onlineshoppingcartcasestudy.model.Product;
import com.roman.onlineshoppingcartcasestudy.repository.ProductRepo;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Transactional(rollbackOn = {DataAccessException.class})
@Service
public class ProductService {
    ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public void saveOrUpdate(Product p) {
        log.info(p.toString());
        productRepo.save(p);
    }
}
