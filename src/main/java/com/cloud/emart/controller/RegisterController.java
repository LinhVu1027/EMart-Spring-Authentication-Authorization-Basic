package com.cloud.emart.controller;

import com.cloud.emart.model.Customer;
import com.cloud.emart.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RegisterController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/register")
    public String registerCustomer(Model model) {

        Customer customer = new Customer();

        model.addAttribute("customer", customer);

        return "register-customer";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerCustomerPost(@Valid @ModelAttribute("customer") Customer customer,
                                       BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "register-customer";
        }

        List<Customer> customerList = customerService.getAllCustomers();

        for (int i = 0; i < customerList.size(); i++) {
            if (customer.getCustomerEmail().equals(customerList.get(i).getCustomerEmail())) {
                model.addAttribute("emailMsg", "Email already exists");

                return "register-customer";
            }

            if (customer.getUsername().equals(customerList.get(i).getUsername())) {
                model.addAttribute("usernameMsg", "Username already exists");

                return "register-customer";
            }
        }

        customer.setEnabled(true);
        customerService.addCustomer(customer);

        return "register-customer-success";
    }
}
