package com.roman.onlineshoppingcartcasestudy.controller;

import com.roman.onlineshoppingcartcasestudy.model.Role;
import com.roman.onlineshoppingcartcasestudy.model.UserAccount;
import com.roman.onlineshoppingcartcasestudy.repository.ProductRepo;
import com.roman.onlineshoppingcartcasestudy.repository.RoleRepo;
import com.roman.onlineshoppingcartcasestudy.repository.UserAccountRepo;
import com.roman.onlineshoppingcartcasestudy.security.AppUserAccountDetailsService;
import com.roman.onlineshoppingcartcasestudy.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;

@Controller
public class UserAccountLoginController {
    @Autowired
    UserAccountRepo userAccountRepo;
    @Autowired
    RoleRepo roleRepo;

    @Autowired
    AppUserAccountDetailsService service;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    ProductRepo productRepo;

    @GetMapping("/login")
    public String login() {
        //clears the cart for new login
        CartService.shoppingCart.clear();
        return "login";
    }

    @GetMapping("/register")
    public String getRegister() {
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(@ModelAttribute("userAccount") UserAccount userAccount, HttpServletRequest request) throws ServletException {
        String password = userAccount.getPassword();
        userAccount.setPassword(bCryptPasswordEncoder.encode(password));
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepo.findById(2).get());
        userAccount.setRoles(roles);
        userAccountRepo.save(userAccount);
        request.login(userAccount.getEmail(), password);
        return "redirect:/";
    }

}
