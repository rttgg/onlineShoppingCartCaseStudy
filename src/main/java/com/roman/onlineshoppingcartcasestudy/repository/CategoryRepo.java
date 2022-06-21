package com.roman.onlineshoppingcartcasestudy.repository;

import com.roman.onlineshoppingcartcasestudy.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
