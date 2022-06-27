package com.roman.onlineshoppingcartcasestudy.controller;

import com.roman.onlineshoppingcartcasestudy.dto.ProductDto;
import com.roman.onlineshoppingcartcasestudy.model.Product;
import com.roman.onlineshoppingcartcasestudy.services.CategoryService;
import com.roman.onlineshoppingcartcasestudy.services.ProductService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Slf4j
@Controller
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ProductController {

    ProductService productService;
    CategoryService categoryService;

    @Autowired
    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/products")
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.findAllProduct());
        return "products";
    }

    @GetMapping("/products/add")
    public String addProduct(Model model) {
        model.addAttribute("productDto", new ProductDto());
        model.addAttribute("categories", categoryService.findAllCategory());
        return "addProducts";
    }

    @PostMapping("/products/add")
    public String postProducts(@ModelAttribute("productDto") ProductDto productDto)
//                               @RequestParam("productImage")MultipartFile file,
                              //@RequestParam("imgName")String imgName) throws IOException
    {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setCategory(categoryService.findCategoryById(productDto.getCategoryId()).get());
        product.setProductDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        //product.setImage(productDto.getImageName());

        productService.addProduct(product);
        return "redirect:/products";

    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable long id){
        productService.deleteProductById(id);
        return "redirect:/products";
    }

    @GetMapping("/products/update/{id}")
    public String updateProduct(@PathVariable long id, Model model) {
        Product product = productService.findProductById(id).get();
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setCategoryId(product.getCategory().getId());
        productDto.setDescription(product.getProductDescription());
        productDto.setPrice(product.getPrice());
        //productDto.setImageName(product.getImageName());
        model.addAttribute("categories", categoryService.findAllCategory());
        model.addAttribute("productDto", productDto);
        return "addProducts";
    }




}
