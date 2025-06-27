package com.netflix.SubscriptionApp.entites;


import com.netflix.SubscriptionApp.enums.SubscriptionType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Random;

@Entity
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subscriptionID;

    @Enumerated(EnumType.STRING)
    private SubscriptionType type;

    private LocalDate startDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_email", referencedColumnName = "email")
    private Customer customer;

    public Subscription() {
    }

    public Subscription(SubscriptionType type,  LocalDate startDate) {
        this.type = type;

        this.startDate = startDate;
    }


    @Override
    public String toString() {
        return "Subscription{" +
                "type='" + type + '\'' +
                ", startDate=" + startDate +
                '}';
    }

    public int getSubscriptionID() {
        return subscriptionID;
    }

    public void setSubscriptionID(int subscriptionID) {
        this.subscriptionID = subscriptionID;
    }

    public SubscriptionType getType() {
        return type;
    }

    public void setType(SubscriptionType type) {
        this.type = type;
    }

    public String getCustomerEmail() {
        return customer.getEmail();
    }



    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setCustomer(Customer customer) {
        this.customer=customer;
    }
}
