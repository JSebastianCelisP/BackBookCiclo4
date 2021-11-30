package com.library.booksS.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class AccountBAlreadyExistsAdvice {
    @ResponseBody
    @ExceptionHandler(AccountBAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String EntityNotFoundAdvice(AccountBAlreadyExistsException ex) {
        return ex.getMessage();
    }
}
