package com.library.booksS.controllers;

import com.library.booksS.repositories.AccountRepository;
import com.library.booksS.models.AccountB;
import com.library.booksS.exceptions.AccountBNotFoundException;
import org.springframework.web.bind.annotation.*;


@RestController
public class AccountController {
    private final AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @PostMapping("/Account")
    AccountB newAccount (@RequestBody AccountB account){
        return accountRepository.save(account);
    }

    @GetMapping("/Account/{idUser}")
    AccountB getAccount (@PathVariable int idUser){
        AccountB account = accountRepository.findById(idUser).orElse(null);

        if(account == null){
            throw new AccountBNotFoundException("No se encontro una cuenta con el id: " + idUser);
        }

        return  account;
    }
}
