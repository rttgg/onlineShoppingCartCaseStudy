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

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
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
    public void testAddMultipleItems() {
        UserAccount userAccount = new UserAccount(150);
        Product productOne = new Product(9L);
        //Product productTwo = new Product(10L);
        Product productThree = new Product(116L);
        CartItem cartItemOne = new CartItem(4, productOne, userAccount);
        //CartItem cartItemTwo = new CartItem(5, productTwo, userAccount);
        CartItem cartItemThree = new CartItem(6, productThree, userAccount);

        cartItemRepo.saveAll(List.of(cartItemOne, cartItemThree));
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

    @Test
    public void testFindByUserAccount() {
        UserAccount userAccount = new UserAccount();
        userAccount.setId(512);
        List<CartItem> cartItems = cartItemRepo.findByUserAccount(userAccount);
        assertEquals(2, cartItems.size());

    }



    @Test
    public void testListItems() {
        List<CartItem> listItems = cartItemRepo.findAll();
        listItems.forEach(System.out::println);
    }

    @Test
    public void testUpdateItem() {
        CartItem cartItem = cartItemRepo.findById(1).get();
        cartItem.setQuantity(3);
        cartItem.setProduct(new Product(116L));
    }

    @Test
    public void testDeleteItem() {
        cartItemRepo.deleteById(3);
    }

}
