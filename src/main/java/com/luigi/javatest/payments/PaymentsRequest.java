package com.luigi.javatest.payments;

public class PaymentsRequest {

    private double amount;

    public PaymentsRequest(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
