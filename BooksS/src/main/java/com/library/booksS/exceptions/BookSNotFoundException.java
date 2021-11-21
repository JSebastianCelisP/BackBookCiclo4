package com.library.booksS.exceptions;

public class BookSNotFoundException extends RuntimeException {
    public BookSNotFoundException(String message) {
        super(message);
    }
}
