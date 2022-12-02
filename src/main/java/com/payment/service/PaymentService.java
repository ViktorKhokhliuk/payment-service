package com.payment.service;

import com.payment.domain.Payment;
import com.payment.domain.PaymentStatus;
import com.payment.dto.PaymentCreatingDto;

public interface PaymentService {
    PaymentStatus getStatusByPaymentId(Long paymentId);

    Payment createPayment(PaymentCreatingDto paymentCreatingDto);

    Iterable<Payment> findAll();
}
