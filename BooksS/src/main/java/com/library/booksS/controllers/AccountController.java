package com.library.booksS.controllers;

import com.library.booksS.repositories.AccountRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    private final AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


}
