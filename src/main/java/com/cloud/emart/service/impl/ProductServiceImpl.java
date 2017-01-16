package com.cloud.emart.service.impl;

import com.cloud.emart.dao.ProductDao;
import com.cloud.emart.model.Customer;
import com.cloud.emart.model.Product;
import com.cloud.emart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Transactional
    public Product getProductById(int id) {
        return productDao.getProductById(id);
    }

    @Transactional
    public List<Product> getProductList() {
        return productDao.getProductList();
    }

    @Transactional
    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    @Transactional
    public void editProduct(Product product) {
        productDao.editProduct(product);
    }

    @Transactional
    public void deleteProduct(Product product) {
        productDao.deleteProduct(product);
    }

    @Transactional
    public List<Product> getProductsByCustomer(Customer customer) {
        return productDao.getProductsByCustomer(customer);
    }
}
