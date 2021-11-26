package com.LibreriaRentalApp.Rental_ms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class BookRAlreadyExistsAdvice {
    @ResponseBody
    @ExceptionHandler(BookRAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String EntityNotFoundAdvice(BookRAlreadyExistsException ex) {
        return ex.getMessage();
    }
}

