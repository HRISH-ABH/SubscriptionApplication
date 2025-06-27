package com.netflix.SubscriptionApp.repository;

import com.netflix.SubscriptionApp.entites.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription,Long> {
}
