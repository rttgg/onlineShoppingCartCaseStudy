package com.roman.onlineshoppingcartcasestudy.controller;

import com.roman.onlineshoppingcartcasestudy.dto.ProductDto;
import com.roman.onlineshoppingcartcasestudy.model.FileInfo;
import com.roman.onlineshoppingcartcasestudy.model.Product;
import com.roman.onlineshoppingcartcasestudy.repository.FileInfoRepo;
import com.roman.onlineshoppingcartcasestudy.services.CategoryService;
import com.roman.onlineshoppingcartcasestudy.services.FileInfoService;
import com.roman.onlineshoppingcartcasestudy.services.ProductService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


@Slf4j
@Controller
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ProductController {
//    private final String UPLOAD_DIR = "~/IdeaProjects/onlineShoppingCartStudy/files";

//    @Value("${app.upload.dir:...}")
    //public String uplaodDir = "~/IdeaProjects/onlineShoppingCartStudy/files";
    public String uplaodDir = System.getProperty("user.dir") + "/files";

    ProductService productService;
    CategoryService categoryService;
    FileInfoRepo fileInfoRepo;
    private final FileInfoService fileInfoService;

    @Autowired
    public ProductController(ProductService productService, CategoryService categoryService, FileInfoRepo fileInfoRepo, FileInfoService fileInfoService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.fileInfoRepo = fileInfoRepo;
        this.fileInfoService = fileInfoService;
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
    public String postProducts(@ModelAttribute("productDto") ProductDto productDto,
                               @RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes,
                              @RequestParam("imgName")String imgName)
    {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setCategory(categoryService.findCategoryById(productDto.getCategoryId()).get());
        product.setProductDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setImage(file.getOriginalFilename());
        product.setImage(fileName);
        if(file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "select an image");
            return "redirect:/products";
        }
//        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));


        try
        {
            Path path = Paths.get(uplaodDir + File.separator + fileName);
            //Files.write(path, file.getBytes());
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            fileInfoRepo.save(new FileInfo(fileName, file.getContentType(), file.getSize(), file.getBytes()));
        } catch (IOException ex)
        {
            log.warn("Upload file exception, file name: " + fileName);
            ex.printStackTrace();
        }
        redirectAttributes.addFlashAttribute("message", "successfully uploaded " + fileName + '!');
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
        productDto.setImageName(product.getImage());
        model.addAttribute("categories", categoryService.findAllCategory());
        model.addAttribute("productDto", productDto);
        return "addProducts";
    }

    @GetMapping("/image")
    public void showImage(@Param("name") String name, HttpServletResponse response, FileInfo fileInfo)
            throws ServletException, IOException {

        fileInfo = fileInfoRepo.findByFileName(name);
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif, image/pdf");
        response.getOutputStream().write(fileInfo.getData());
        response.getOutputStream().close();
    }




}
