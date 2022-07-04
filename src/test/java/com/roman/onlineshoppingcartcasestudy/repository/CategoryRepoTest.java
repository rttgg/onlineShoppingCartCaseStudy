package com.roman.onlineshoppingcartcasestudy.repository;

import com.roman.onlineshoppingcartcasestudy.model.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)//rollback to db
public class CategoryRepoTest {

    @Autowired
    private CategoryRepo categoryRepo;

    @Test
    public void testCreateNewCategory() {
        Category savedCategory = categoryRepo.save(new Category("Medicine"));
        assertThat(savedCategory.getId()).isGreaterThan(0);
    }
}
