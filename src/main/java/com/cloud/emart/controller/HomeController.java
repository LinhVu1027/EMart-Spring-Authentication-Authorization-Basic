package com.cloud.emart.controller;

import com.cloud.emart.dao.ProductDao;
import com.cloud.emart.model.Product;
import com.cloud.emart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


@Controller
public class HomeController {

    private Path path;

    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String home(Model model) {
        List<Product> products = productService.getProductList();
        model.addAttribute("products", products);
        return "home";
    }

    @RequestMapping("/product/view-product/{id}")
    public String viewProduct(@PathVariable int id, Model model) throws IOException {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);

        return "view-product";
    }

    @RequestMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        Model model) {
        if (error != null) {
            model.addAttribute("error", "Invalid username and password.");
        }

        if (logout != null) {
            model.addAttribute("msg", "You have been logged out successfully.");
        }

        return "login";
    }

}
