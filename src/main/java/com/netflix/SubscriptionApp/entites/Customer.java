package com.netflix.SubscriptionApp.entites;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Customer")
public class Customer {
    private String name;
    @Id
    private String email;
    private String phone;


    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }


    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Payment> payments = new ArrayList<>();

    public void addPayment(Payment p){
      this.payments.add(p);
      p.setCustomer(this);
    }

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Subscription> subscriptions = new ArrayList<>();

    public List<Subscription> getSubscription() {
        return subscriptions;
    }


    public void addSubscription(Subscription subscription) {
        this.subscriptions.add(subscription);
        subscription.setCustomer(this);
    }

    public Customer() {
    }

    public Customer(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }


    public String showDetails() {
        return "Customer: " + name + ", Email: " + email +
                ", Phone: " + phone +
                ", Subscription: " + (subscriptions != null ? subscriptions.toString() : "None");
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSubscription(List<Subscription> subscription) {
        this.subscriptions = subscription;
    }
}

