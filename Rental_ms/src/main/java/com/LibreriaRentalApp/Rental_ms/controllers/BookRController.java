package com.LibreriaRentalApp.Rental_ms.controllers;

import com.LibreriaRentalApp.Rental_ms.repositories.BookRRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookRController {
    private final BookRRepository bookRRepository;

    public BookRController(BookRRepository bookRRepository) {
        this.bookRRepository = bookRRepository;
    }

}
