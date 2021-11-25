package com.LibreriaRentalApp.Rental_ms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class InsufficientUnitsAdvice {
    @ResponseBody
    @ExceptionHandler(com.LibreriaRentalApp.Rental_ms.exceptions.InsufficientUnitsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String InsufficientUnitsAdvice(com.LibreriaRentalApp.Rental_ms.exceptions.InsufficientUnitsException ex) {
        return ex.getMessage();
    }
}
