package com.netflix.SubscriptionApp.services;

import com.netflix.SubscriptionApp.entites.Customer;


import com.netflix.SubscriptionApp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerService {



 @Autowired
    CustomerRepository customerRepository;

    public String createCustomer(Customer c) {
        boolean customerExists = customerRepository.existsById(c.getEmail());

        if (!customerExists) {
            customerRepository.save(c);
            return "Customer Added Successfully \n Details : " + c.showDetails();

        } else {
            return "Customer Already Exists!!!";

        }

    }

    public Optional<Customer> getCustomer(String email) {
     return customerRepository.findById(email);

    }

    public List<Customer> getAllcustomers() {
        return customerRepository.findAll();
    }

    public String deleteCustomer(String email) {
       if(customerRepository.existsById(email)){
           customerRepository.deleteById(email);
           return "Deleted";
       }
       return "Doesn't Exists";
    }




}
