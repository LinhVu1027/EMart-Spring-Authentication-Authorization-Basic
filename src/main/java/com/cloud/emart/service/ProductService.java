package com.cloud.emart.service;

import com.cloud.emart.model.Customer;
import com.cloud.emart.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProductList();

    Product getProductById(int id);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);

    List<Product> getProductsByCustomer(Customer customer);
}
