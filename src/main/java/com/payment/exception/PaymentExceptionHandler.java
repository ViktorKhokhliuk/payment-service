package com.payment.exception;

import com.payment.dto.ErrorResponseDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@Log4j2
@RestControllerAdvice
public class PaymentExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponseDto> handleException(EntityNotFoundException exception) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(exception.getMessage(), LocalDateTime.now());
        log.error(exception.getMessage(), exception);
        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<?> handleException(Exception exception) {
        log.error(exception.getMessage(), exception);
        return ResponseEntity.internalServerError().build();
    }
}
