package com.payment.service.impl;

import com.payment.domain.Payment;
import com.payment.domain.PaymentStatus;
import com.payment.dto.PaymentCreatingDto;
import com.payment.exception.EntityNotFoundException;
import com.payment.mapper.TicketPaymentDtoToPaymentMapper;
import com.payment.repository.PaymentRepository;
import com.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final TicketPaymentDtoToPaymentMapper paymentMapper;

    @Override
    public Payment createPayment(PaymentCreatingDto paymentCreatingDto) {
        Payment newPayment = paymentMapper.map(paymentCreatingDto);
        return paymentRepository.save(newPayment);
    }

    @Override
    public List<Payment> findAllByStatus(PaymentStatus status) {
        return paymentRepository.findAllByStatus(status);
    }

    @Override
    public Payment findById(Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("payment with id " + id + " not found"));
    }

    @Override
    public void updateAll(List<Payment> payments) {
        paymentRepository.saveAll(payments);
    }
}
