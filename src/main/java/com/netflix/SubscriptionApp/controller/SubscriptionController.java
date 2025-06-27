package com.netflix.SubscriptionApp.controller;

import com.netflix.SubscriptionApp.entites.Subscription;
import com.netflix.SubscriptionApp.enums.SubscriptionType;
import com.netflix.SubscriptionApp.services.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    @Autowired
    SubscriptionService subscriptionService;

    @PostMapping("/buySubscription")
    public String buySubscription(@RequestParam String email, @RequestParam SubscriptionType type) {
        boolean success = subscriptionService.buySubscription(email, type);
        if(success){
            return "Subscription was added successfully";
        }
        return "Failed!!!";

    }

    @GetMapping("/showSubscriptions")
    public List<Subscription> getAllSubscriptions(@RequestParam String email){
       return subscriptionService.getAllSubscriptions(email);
    }
}
