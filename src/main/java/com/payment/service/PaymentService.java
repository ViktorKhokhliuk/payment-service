package com.payment.service;

import com.payment.domain.Payment;
import com.payment.domain.PaymentStatus;
import com.payment.dto.TicketPaymentDto;

public interface PaymentService {
    PaymentStatus getStatusByPaymentId(Long paymentId);

    Payment createPayment(TicketPaymentDto ticketPaymentDto);

    Iterable<Payment> findAll();
}
