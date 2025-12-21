package com.luigi.javatest.payments;

public interface PaymentGateway {

    PaymentResponse requestPayment(PaymentsRequest request);
}
