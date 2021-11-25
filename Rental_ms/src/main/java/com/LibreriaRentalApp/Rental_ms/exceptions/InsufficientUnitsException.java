package com.LibreriaRentalApp.Rental_ms.exceptions;

public class InsufficientUnitsException extends RuntimeException {
    public InsufficientUnitsException(String message) {
        super(message);
    }
}
