package com.payment.service;

import com.payment.domain.Payment;
import com.payment.domain.PaymentStatus;
import com.payment.dto.PaymentCreatingDto;

import java.util.List;

public interface PaymentService {

    Payment createPayment(PaymentCreatingDto paymentCreatingDto);

    List<Payment> findAllByStatus(PaymentStatus status);

    Payment findById(Long id);

    void updateAll(List<Payment> payments);
}
