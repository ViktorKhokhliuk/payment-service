package com.payment.service.impl;

import com.payment.domain.Payment;
import com.payment.domain.PaymentStatus;
import com.payment.dto.PaymentCreatingDto;
import com.payment.mapper.TicketPaymentDtoToPaymentMapper;
import com.payment.repository.PaymentRepository;
import com.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final TicketPaymentDtoToPaymentMapper paymentMapper;

    @Override
    public PaymentStatus getStatusByPaymentId(Long paymentId) {
        PaymentStatus[] paymentStatuses = PaymentStatus.values();
        int index = ThreadLocalRandom.current().nextInt(paymentStatuses.length);
        return paymentStatuses[index];
    }

    @Override
    public Payment createPayment(PaymentCreatingDto paymentCreatingDto) {
        Payment newPayment = paymentMapper.map(paymentCreatingDto);
        return paymentRepository.save(newPayment);
    }

    @Override
    public Iterable<Payment> findAll() {;
        return paymentRepository.findAll();
    }
}
