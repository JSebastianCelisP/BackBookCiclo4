package com.LibreriaRentalApp.Rental_ms.controllers;

import com.LibreriaRentalApp.Rental_ms.repositories.AccountRepository;
import com.LibreriaRentalApp.Rental_ms.repositories.BookRRepository;
import com.LibreriaRentalApp.Rental_ms.repositories.TransactionRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {
    private final BookRRepository bookRRepository;
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    public TransactionController(BookRRepository bookRRepository, TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.bookRRepository = bookRRepository;
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }
}
