package com.payment.repository;

import com.payment.domain.Payment;
import com.payment.domain.PaymentStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PaymentRepository extends CrudRepository<Payment, Long> {

    List<Payment> findAllByStatus(PaymentStatus status);
}
