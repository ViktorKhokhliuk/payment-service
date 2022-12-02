package com.payment.controller;

import com.payment.domain.Payment;
import com.payment.domain.PaymentStatus;
import com.payment.dto.ResponsePaymentIdDto;
import com.payment.dto.PaymentCreatingDto;
import com.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @GetMapping("/status/{id}")
    public PaymentStatus getPaymentStatus(@PathVariable(name = "id") Long paymentId) {
        return paymentService.getStatusByPaymentId(paymentId);
    }

    @PostMapping
    public ResponsePaymentIdDto payForTicket(@RequestBody PaymentCreatingDto paymentCreatingDto) {
        Long paymentId = paymentService.createPayment(paymentCreatingDto).getId();
        return new ResponsePaymentIdDto(paymentId);
    }

    @GetMapping
    public Iterable<Payment> findAll() {
        return paymentService.findAll();
    }

}
