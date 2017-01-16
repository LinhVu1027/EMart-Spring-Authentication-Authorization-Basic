package com.cloud.emart.dao;

import com.cloud.emart.model.Customer;

import java.util.List;

public interface CustomerDao {

    List<Customer> getAllCustomers();

    Customer getCustomerById(int id);

    void addCustomer(Customer customer);

    Customer getCustomerByUsername(String username);
}
