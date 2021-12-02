package com.LibreriaRentalApp.Rental_ms.controllers;

import com.LibreriaRentalApp.Rental_ms.repositories.AccountRepository;
import com.LibreriaRentalApp.Rental_ms.models.AccountB;
import com.LibreriaRentalApp.Rental_ms.exceptions.AccountBAlreadyExistsException;
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
        AccountB accountc = accountRepository.findById(account.getIdUser()).orElse(null);
        if(accountc != null){
            throw new AccountBAlreadyExistsException("Account already exists");
        }else{
            return accountRepository.save(account);
       }
    }

    @GetMapping("/Account/{idUser}")
    AccountB getAccount(@PathVariable int idUser) {
        AccountB account = accountRepository.findById(idUser).orElse(null);

        if (account == null) {
            throw new AccountBNotFoundException("User not found");
        }

        return account;
    }

    @PostMapping("/Account/update/{idUser}")
    AccountB updateAccount(@RequestBody AccountB accountUpdate, @PathVariable int idUser) {
        AccountB account = accountRepository.findById(idUser).orElse(null);
        if(account == null) {
            throw new AccountBNotFoundException("Account not found");
        }else{
            return accountRepository.save(accountUpdate);
        }
    }

    @DeleteMapping("/Account/delete/{idUser}")
    void deleteAccount(@PathVariable int idUser) {
        AccountB account = accountRepository.findById(idUser).orElse(null);
        if(account == null){
            throw new AccountBNotFoundException("Account not found");
        }else{
            accountRepository.deleteById(idUser);
        }
    }
}
