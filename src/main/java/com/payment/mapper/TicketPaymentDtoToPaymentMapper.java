package com.payment.mapper;

import com.payment.domain.Payment;
import com.payment.domain.PaymentStatus;
import com.payment.dto.PaymentCreatingDto;
import org.springframework.stereotype.Component;

@Component
public class TicketPaymentDtoToPaymentMapper {

    public Payment map(PaymentCreatingDto dto) {
        Payment payment = new Payment();
        payment.setFirstName(dto.getFirstName());
        payment.setLastName(dto.getLastName());
        payment.setPatronymic(dto.getPatronymic());
        payment.setSum(dto.getSum());
        payment.setStatus(PaymentStatus.NEW);
        return payment;
    }
}
