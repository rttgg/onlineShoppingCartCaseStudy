package com.roman.onlineshoppingcartcasestudy.repository;

import com.roman.onlineshoppingcartcasestudy.model.Role;
import com.roman.onlineshoppingcartcasestudy.model.UserAccount;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import org.springframework.test.annotation.Rollback;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)//rollback to db
public class UserAccountRepoTest {

    @Autowired
    private UserAccountRepo userAccountRepo;


    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void test() {

    }
    @Test
    public void testCreateRole() {
        //Role roleAdmin = new Role("Admin");
        Role roleEditor = new Role("Editor");
        Role roleVisitor = new Role("Visitor");
        entityManager.persist(roleEditor);
        entityManager.persist(roleVisitor);

    }

    @Test
    public void testCreateNewUserWithOneRole() {
        Role roleAdmin = entityManager.find(Role.class, 2);
        UserAccount userAccount = new UserAccount( "rt@gmail.com", "pass");
        userAccount.addRole(roleAdmin);
        userAccountRepo.save(userAccount);
    }

    @Test
    public void testGetUser() {
        UserAccount userAccount = userAccountRepo.findById(150).get();
        System.out.println(userAccount.getEmail());
        System.out.println(userAccount.getRoles());
    }

    @Test
    public void testRemoveUser() {
        userAccountRepo.deleteById(786);
    }


}
