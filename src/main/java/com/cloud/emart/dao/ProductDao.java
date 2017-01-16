package com.cloud.emart.dao;

import java.util.List;

import com.cloud.emart.model.Customer;
import com.cloud.emart.model.Product;

public interface ProductDao {

    List<Product> getProductList();

    Product getProductById(int id);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);

    List<Product> getProductsByCustomer(Customer customer);
}
