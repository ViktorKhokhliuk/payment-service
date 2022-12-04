package com.payment.service.impl;

import com.payment.domain.PaymentStatus;
import com.payment.service.PaymentStatusService;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class PaymentStatusServiceImpl implements PaymentStatusService {

    @Override
    public PaymentStatus findByPaymentId(Long paymentId) {
        PaymentStatus[] paymentStatuses = PaymentStatus.values();
        int index = ThreadLocalRandom.current().nextInt(paymentStatuses.length);
        return paymentStatuses[index];
    }
}
