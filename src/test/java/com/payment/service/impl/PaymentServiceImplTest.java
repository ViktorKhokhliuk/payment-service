package com.payment.service.impl;

import com.payment.AbstractUnitTest;
import com.payment.domain.Payment;
import com.payment.domain.PaymentStatus;
import com.payment.dto.PaymentCreatingDto;
import com.payment.exception.EntityNotFoundException;
import com.payment.mapper.TicketPaymentDtoToPaymentMapper;
import com.payment.repository.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class PaymentServiceImplTest extends AbstractUnitTest {
    @Mock
    private PaymentRepository paymentRepository;
    @Mock
    private TicketPaymentDtoToPaymentMapper paymentMapper;
    @InjectMocks
    private PaymentServiceImpl paymentService;

    @Test
    void findByIdShouldReturnPaymentWhenItExists() {
        //GIVEN
        Payment expectedPayment = createPayment();

        when(paymentRepository.findById(expectedPayment.getId())).thenReturn(Optional.of(expectedPayment));

        //WHEN
        Payment resultPayment = paymentService.findById(expectedPayment.getId());

        //THEN
        assertEquals(expectedPayment, resultPayment);
    }

    @Test
    void findByIdShouldThrowEntityNotFoundExceptionWhenPaymentDoesNotExist() {
        //GIVEN, WHEN
        when(paymentRepository.findById(anyLong())).thenReturn(Optional.empty());

        //THEN
        assertThrows(EntityNotFoundException.class, () -> paymentService.findById(anyLong()));
    }

    @Test
    void findAllByStatusShouldReturnAllPaymentsWithNewStatus() {
        //GIVEN
        List<Payment> expectedPayments = createPaymentsWithNewStatus();

        when(paymentRepository.findAllByStatus(PaymentStatus.NEW)).thenReturn(expectedPayments);

        //WHEN
        List<Payment> resultPayments = paymentService.findAllByStatus(PaymentStatus.NEW);

        //THEN
        assertEquals(expectedPayments, resultPayments);
    }

    @Test
    void updateAllShouldCallRepositoryMethod() {
        paymentService.updateAll(anyList());

        verify(paymentRepository).saveAll(anyList());
    }

    @Test
    void createPaymentShouldReturnNewPayment() {
        //GIVEN
        Payment expectedPayment = createPayment();
        PaymentCreatingDto dto = new PaymentCreatingDto(
                expectedPayment.getFirstName(),
                expectedPayment.getLastName(),
                expectedPayment.getPatronymic(),
                expectedPayment.getSum()
        );

        when(paymentMapper.map(dto)).thenReturn(expectedPayment);
        when(paymentRepository.save(expectedPayment)).thenReturn(expectedPayment);

        //WHEN
        Payment resultPayment = paymentService.createPayment(dto);

        //THEN
        assertEquals(expectedPayment, resultPayment);
    }
}