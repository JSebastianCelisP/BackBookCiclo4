package com.library.booksS.controllers;

import com.library.booksS.repositories.AccountRepository;
import com.library.booksS.repositories.BookSRepository;
import com.library.booksS.repositories.TransactionRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {
    private final BookSRepository bookSRepository;
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    public TransactionController(BookSRepository bookSRepository, TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.bookSRepository = bookSRepository;
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }
}
