package com.netflix.SubscriptionApp.controller;

import com.netflix.SubscriptionApp.entites.Payment;
import com.netflix.SubscriptionApp.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    PaymentService paymentService;
    @PostMapping("/makePayments")
    public String makePayments(@RequestParam String email) {
        return paymentService.makePayments(email);

    }

    @GetMapping("/getPayments")
    public List<Payment> getPayments(@RequestParam String email) {
        return paymentService.getPaymentByEmail(email);


    }
}
