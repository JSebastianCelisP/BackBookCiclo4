package com.library.booksS.controllers;

import com.library.booksS.repositories.BookSRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookSController {
    private final BookSRepository bookSRepository;

    public BookSController(BookSRepository bookSRepository) {
        this.bookSRepository = bookSRepository;
    }

}
