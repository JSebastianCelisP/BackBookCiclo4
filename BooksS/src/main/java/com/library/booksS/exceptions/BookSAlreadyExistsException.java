package com.library.booksS.exceptions;


public class BookSAlreadyExistsException extends RuntimeException {
    public BookSAlreadyExistsException(String message) {
        super(message);
    }

}
