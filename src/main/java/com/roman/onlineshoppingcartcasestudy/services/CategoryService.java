package com.roman.onlineshoppingcartcasestudy.services;

import com.roman.onlineshoppingcartcasestudy.model.Category;
import com.roman.onlineshoppingcartcasestudy.repository.CategoryRepo;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Transactional(rollbackOn = {DataAccessException.class})
public class CategoryService {

    CategoryRepo categoryRepo;
    @Autowired
    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public void addCategory(Category category) {
        categoryRepo.save(category);
    }

    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    public Optional<Category> findCategoryById(int id) {
        return categoryRepo.findById(id);
    }
    public void deleteCategoryById(int id) {
        categoryRepo.deleteById(id);
    }

    public void saveOrUpdate(Category c) {
        log.info(c.toString());
        categoryRepo.save(c);
    }
}
