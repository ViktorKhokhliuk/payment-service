package com.payment;

import com.payment.domain.Payment;
import com.payment.domain.PaymentStatus;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AbstractUnitTest {

    protected Payment createPayment() {
        Payment payment = new Payment();
        payment.setId(1L);
        payment.setFirstName("First Name");
        payment.setLastName("Last Name");
        payment.setPatronymic("Patronymic");
        payment.setSum(1000D);
        payment.setStatus(PaymentStatus.NEW);
        return payment;
    }

    protected List<Payment> createPaymentsWithNewStatus() {
        Payment payment1 = createPayment();
        Payment payment2 = createPayment();
        Payment payment3 = createPayment();

        payment2.setId(2L);
        payment3.setId(3L);

        return List.of(payment1, payment2, payment3);
    }
}
