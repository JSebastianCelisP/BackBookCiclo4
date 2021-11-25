package com.LibreriaRentalApp.Rental_ms.controllers;

import com.LibreriaRentalApp.Rental_ms.repositories.AccountRepository;
import com.LibreriaRentalApp.Rental_ms.models.AccountB;
import com.LibreriaRentalApp.Rental_ms.exceptions.AccountBNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {
    private final AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @PostMapping("/Account")
    AccountB newAccount(@RequestBody AccountB account) {
        return accountRepository.save(account);
    }

    @GetMapping("/Account/{idUser}")
    AccountB getAccount(@PathVariable int idUser) {
        AccountB account = accountRepository.findById(idUser).orElse(null);

        if (account == null) {
            throw new AccountBNotFoundException("No se encontro una cuenta con el id: " + idUser);
        }

        return account;
    }

    @PostMapping("/Account/update")
    AccountB updateAccount(@RequestBody AccountB account) {
        return accountRepository.save(account);
    }

    @DeleteMapping("/Account/delete")
    void deleteAccount(@RequestBody AccountB account) {
        accountRepository.delete(account);
        return;
    }

}
