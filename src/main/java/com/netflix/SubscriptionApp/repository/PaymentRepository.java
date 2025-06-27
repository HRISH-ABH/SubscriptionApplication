package com.netflix.SubscriptionApp.repository;

import com.netflix.SubscriptionApp.entites.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
