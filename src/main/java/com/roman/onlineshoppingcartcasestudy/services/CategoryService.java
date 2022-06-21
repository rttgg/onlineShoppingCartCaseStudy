package com.roman.onlineshoppingcartcasestudy.services;

import com.roman.onlineshoppingcartcasestudy.model.Category;
import com.roman.onlineshoppingcartcasestudy.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    public void addCategory(Category category) {
        categoryRepo.save(category);
    }

    public List<Category> getAllCategory() {
        return categoryRepo.findAll();
    }
}
