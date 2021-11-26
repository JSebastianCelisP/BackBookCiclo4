package com.LibreriaRentalApp.Rental_ms.exceptions;


public class BookRAlreadyExistsException extends RuntimeException {
    public BookRAlreadyExistsException(String message) {
        super(message);
    }

}
