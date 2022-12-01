package com.payment.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class TicketPaymentDto {

    private final String firstName;
    private final String lastName;
    private final String patronymic;
    private final Double sum;

}
