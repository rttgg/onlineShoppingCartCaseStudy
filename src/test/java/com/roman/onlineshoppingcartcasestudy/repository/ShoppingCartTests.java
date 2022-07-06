package com.roman.onlineshoppingcartcasestudy.repository;

import com.roman.onlineshoppingcartcasestudy.model.CartItem;
import com.roman.onlineshoppingcartcasestudy.model.Product;
import com.roman.onlineshoppingcartcasestudy.model.UserAccount;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.junit.Assert.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)//rollback to db
public class ShoppingCartTests {

    @Autowired
    private CartItemRepo cartItemRepo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void test() {

    }

    @Test
    public void testAddItemFromDatabase() {
        Product product = entityManager.find(Product.class, 9L);
       UserAccount userAccount = entityManager.find(UserAccount.class, 150);
        CartItem cartItem = new CartItem(1, product, userAccount);
        cartItemRepo.save(cartItem);
    }

    @Test
    public void testAddItemById() {
        Product product = new Product(10L);
        UserAccount userAccount = new UserAccount(512);
        CartItem cartItem = new CartItem(2, product, userAccount);
        cartItemRepo.save(cartItem);
    }


    @Test
    public void testAddOneCartItem() {
        Product product = entityManager.find(Product.class,10L);
        UserAccount userAccount = entityManager.find(UserAccount.class, 512);
        CartItem cartItem = new CartItem();
        cartItem.setUserAccount(userAccount);
        cartItem.setProduct(product);
        cartItem.setQuantity(4);
        CartItem saveCartItem = cartItemRepo.save(cartItem);
        assertTrue(saveCartItem.getId() > 0);

    }

}
