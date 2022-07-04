package com.roman.onlineshoppingcartcasestudy.repository;

import com.roman.onlineshoppingcartcasestudy.model.Role;
import com.roman.onlineshoppingcartcasestudy.model.UserAccount;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.Set;

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

        //entityManager.persist(roleAdmin);
        entityManager.persist(roleEditor);
        entityManager.persist(roleVisitor);

    }

    @Test
    public void testCreateNewUserWithOneRole() {
        Role roleAdmin = entityManager.find(Role.class, 1);
        UserAccount userAccount = new UserAccount( "rt@gmail.com", "pass");
        userAccount.addRole(roleAdmin);
        userAccountRepo.save(userAccount);
    }

    @Test
    public void testCreateNewUserWithNewRole() {
        Role roleSaleperson = new Role("Salesperson");
        UserAccount userAccount = new UserAccount("rttgg1@gmail.com", "pass", "rom", "las");
        userAccount.addRole(roleSaleperson);
        userAccountRepo.save(userAccount);
    }
    @Test
    public void testGetUser() {
        UserAccount userAccount = userAccountRepo.findById(1).get();
        System.out.println(userAccount.getEmail());
        System.out.println(userAccount.getRoles());
    }
    //Both test are the same one just using entityManager
    @Test
    public void testGetUsea() {
        UserAccount userAccount = userAccountRepo.findById(1).get();
        entityManager.detach(userAccount);
        System.out.println(userAccount.getEmail());
        System.out.println(userAccount.getRoles());
    }

    @Test
    public void testRemoveUser() {
        userAccountRepo.deleteById(379);
    }


}
