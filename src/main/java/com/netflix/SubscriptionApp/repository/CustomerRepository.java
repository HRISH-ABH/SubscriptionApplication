package com.netflix.SubscriptionApp.repository;

import com.netflix.SubscriptionApp.entites.Customer;
import com.netflix.SubscriptionApp.entites.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String> {


}
