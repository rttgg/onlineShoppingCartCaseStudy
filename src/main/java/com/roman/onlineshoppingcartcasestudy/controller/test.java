package com.roman.onlineshoppingcartcasestudy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {
    @GetMapping("/")
    public String home() {
        return ("<h1>Welcome</h1>");
    }
}
