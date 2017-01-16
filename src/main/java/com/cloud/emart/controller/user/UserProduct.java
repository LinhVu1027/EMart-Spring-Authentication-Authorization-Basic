package com.cloud.emart.controller.user;

import com.cloud.emart.model.Customer;
import com.cloud.emart.model.Product;
import com.cloud.emart.service.CustomerService;
import com.cloud.emart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
@RequestMapping("/user")
public class UserProduct {

    private Path path;

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping
    public String homeUser(Model model, @AuthenticationPrincipal User activeUser) {
        Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
        List<Product> products = productService.getProductsByCustomer(customer);
        model.addAttribute("products", products);
        return "home-user";
    }


    @RequestMapping(value="/product/add-product")
    public String addProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);

        return "add-product";
    }

    @RequestMapping(value = "/product/add-product", method = RequestMethod.POST)
    public String addProductPost(@Valid @ModelAttribute("product") Product product,
                                 BindingResult result, HttpServletRequest request,
                                 @AuthenticationPrincipal User activeUser) {

        if (result.hasErrors()) {
            return "add-product";
        }

        Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
        product.setCustomer(customer);

        productService.addProduct(product);

        MultipartFile productImage = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "/resources/images/" + product.getProductId() + ".png");

        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed.", e);
            }
        }

        return "redirect:/user";
    }

    @RequestMapping("/product/edit-product/{id}")
    public String editProduct(@PathVariable int id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);

        return "edit-product";
    }

    @RequestMapping(value = "/product/edit-product", method = RequestMethod.POST)
    public String editProductPost(@Valid @ModelAttribute("product") Product product,
                                  BindingResult result, HttpServletRequest request,
                                  @AuthenticationPrincipal User activeUser) {

        if (result.hasErrors()) {
            return "edit-product";
        }

        MultipartFile productImage = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "/resources/images/" + product.getProductId() + ".png");

        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed.", e);
            }
        }

        productService.editProduct(product);

        return "redirect:/user";
    }

    @RequestMapping("/product/delete-product/{id}")
    public String deleteProduct(@PathVariable int id, HttpServletRequest request) {
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        Path path = Paths.get(rootDirectory + "/resources/images/" + id + ".png");

        if (Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Product product = productService.getProductById(id);
        productService.deleteProduct(product);

        return "redirect:/user";
    }
}
