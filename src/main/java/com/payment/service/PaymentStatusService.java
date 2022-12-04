package com.payment.service;

import com.payment.domain.PaymentStatus;

public interface PaymentStatusService {

    PaymentStatus findByPaymentId(Long paymentId);
}
