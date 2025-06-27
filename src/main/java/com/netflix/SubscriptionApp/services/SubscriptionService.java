package com.netflix.SubscriptionApp.services;

import com.netflix.SubscriptionApp.entites.Customer;
import com.netflix.SubscriptionApp.entites.Subscription;
import com.netflix.SubscriptionApp.enums.SubscriptionType;
import com.netflix.SubscriptionApp.repository.CustomerRepository;
import com.netflix.SubscriptionApp.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class SubscriptionService {



    @Autowired
    CustomerRepository  customerRepository;
    @Autowired
    SubscriptionRepository subscriptionRepository;

    public boolean buySubscription(String email, SubscriptionType type) {
        for (Customer c : customerRepository.findAll()) {
            if (c.getEmail().equalsIgnoreCase(email)) {
                c.addSubscription(new Subscription(type,LocalDate.now()));
                subscriptionRepository.save(new Subscription(type, LocalDate.now()));

                return true;
            }
        }
        return false;

    }

    public List<Subscription> getAllSubscriptions(String email) {
        for (Customer c : customerRepository.findAll()) {
            if (c.getEmail().equalsIgnoreCase(email)) {
                return c.getSubscription();


            }
        }
        return new ArrayList<>();
    }
}
