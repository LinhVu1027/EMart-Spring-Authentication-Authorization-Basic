package com.cloud.emart.service;

import com.cloud.emart.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomers();

    Customer getCustomerById(int id);

    void addCustomer(Customer customer);

    Customer getCustomerByUsername(String username);
}
