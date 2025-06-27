package com.netflix.SubscriptionApp.entites;

import jakarta.persistence.*;

@Entity

public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentID;


    public Long getPaymentID() {
        return paymentID;
    }





    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_email", referencedColumnName = "email")
    private Customer customer;

    public Payment() {

    }

    @Override
    public String toString() {
        return "Payment{" + "paymentID=" + paymentID + ", customerEmail=" + customer.getEmail() + '}';
    }

    public void setPaymentID(Long paymentID) {
        this.paymentID = paymentID;
    }



    public void setCustomer(Customer customer) {
        this.customer=customer;
    }

    public String getCustomerEmail() {
        return this.customer.getEmail();
    }
}
