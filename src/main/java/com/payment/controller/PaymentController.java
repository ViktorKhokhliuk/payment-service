package com.payment.controller;

import com.payment.domain.Payment;
import com.payment.domain.PaymentStatus;
import com.payment.dto.ResponsePaymentIdDto;
import com.payment.dto.PaymentCreatingDto;
import com.payment.service.PaymentService;
import com.payment.service.PaymentStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;
    private final PaymentStatusService paymentStatusService;

    @GetMapping("/status/{id}")
    public PaymentStatus findPaymentStatusById(@PathVariable(name = "id") Long paymentId) {
        return paymentStatusService.findByPaymentId(paymentId);
    }

    @PostMapping
    public ResponsePaymentIdDto payForTicket(@RequestBody PaymentCreatingDto paymentCreatingDto) {
        Long paymentId = paymentService.createPayment(paymentCreatingDto).getId();
        return new ResponsePaymentIdDto(paymentId);
    }

    @GetMapping("/{id}")
    public Payment findById(@PathVariable(name = "id") Long id) {
        return paymentService.findById(id);
    }

    @GetMapping("all/{status}")
    public List<Payment> findAllByStatus(@PathVariable(name = "status") String status) {
        return paymentService.findAllByStatus(PaymentStatus.valueOf(status));
    }

    @PutMapping()
    public ResponseEntity<?> updateAll(@RequestBody List<Payment> payments) {
        paymentService.updateAll(payments);
        return ResponseEntity.ok().build();
    }
}
