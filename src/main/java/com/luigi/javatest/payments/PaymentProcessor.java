package com.luigi.javatest.payments;

public class PaymentProcessor {

    private PaymentGateway paymentGateway;

    public PaymentProcessor(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public boolean makePayment(double amount) {

        PaymentResponse response = paymentGateway.requestPayment(new PaymentsRequest(amount));
        return response.getStatus() == PaymentResponse.PaymentStatus.OK;
    }
}
