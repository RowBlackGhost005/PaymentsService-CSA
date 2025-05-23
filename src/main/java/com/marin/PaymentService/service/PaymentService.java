package com.marin.PaymentService.service;

import com.marin.PaymentService.entities.Payment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PaymentService {

    Payment registerPayment(Payment payment);

    List<Payment> fetchAllPayments();

    Payment fetchPaymentOrderId(int orderId);

    Payment changePaymentStatusById(int paymentId, String newStatus);


}