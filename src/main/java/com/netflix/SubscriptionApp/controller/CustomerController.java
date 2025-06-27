package com.netflix.SubscriptionApp.controller;

import com.netflix.SubscriptionApp.entites.Customer;
import com.netflix.SubscriptionApp.entites.Payment;
import com.netflix.SubscriptionApp.entites.Subscription;

import com.netflix.SubscriptionApp.repository.CustomerRepository;
import com.netflix.SubscriptionApp.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;



    @PostMapping("/create")
    public String createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @GetMapping("/getCustomer")
    public Optional<Customer> getCustomer(@RequestParam String email) {
        return customerService.getCustomer(email);
    }

    @GetMapping("/getAllCustomer")
    public List<Customer> getCustomer() {
        return customerService.getAllcustomers();
    }

    @DeleteMapping("/delete")
    public String deleteCustomer(@RequestParam String email) {
        return customerService.deleteCustomer(email);
    }





}
