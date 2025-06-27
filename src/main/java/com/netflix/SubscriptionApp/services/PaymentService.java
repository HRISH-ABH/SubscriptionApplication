package com.netflix.SubscriptionApp.services;

import com.netflix.SubscriptionApp.entites.Customer;
import com.netflix.SubscriptionApp.entites.Payment;
import com.netflix.SubscriptionApp.repository.CustomerRepository;
import com.netflix.SubscriptionApp.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PaymentService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    PaymentRepository paymentRepository;
    public String makePayments(String email) {

        Random random = new Random();
        boolean paymentSuccess = random.nextBoolean();


        if (paymentSuccess) {
            for (Customer c : customerRepository.findAll()) {
                if (c.getEmail().equalsIgnoreCase(email)) {
                    Payment p=new Payment();
                    c.addPayment(p);
                    paymentRepository.saveAll(c.getPayments());
                }
            }
            return "Payment made Successfully :";
        }
        return "Payment failed";


    }

    public List<Payment> getPaymentByEmail(String email) {

        for(Customer c: customerRepository.findAll()){
            if(c.getEmail().equalsIgnoreCase(email)){
                return c.getPayments();
            }
        }
        return new ArrayList<>();


    }
}
