package com.LibreriaRentalApp.Rental_ms.controllers;

import com.LibreriaRentalApp.Rental_ms.repositories.AccountRepository;
import com.LibreriaRentalApp.Rental_ms.models.AccountB;
import com.LibreriaRentalApp.Rental_ms.exceptions.AccountBInvalidCredentialsException;
import com.LibreriaRentalApp.Rental_ms.exceptions.AccountBNotFoundException;
import com.LibreriaRentalApp.Rental_ms.repositories.BookRRepository;
import com.LibreriaRentalApp.Rental_ms.models.BookR;
import com.LibreriaRentalApp.Rental_ms.exceptions.BookRNotFoundException;
import com.LibreriaRentalApp.Rental_ms.repositories.TransactionRepository;
import com.LibreriaRentalApp.Rental_ms.models.Transaction;
import com.LibreriaRentalApp.Rental_ms.exceptions.InsufficientUnitsException;
import com.LibreriaRentalApp.Rental_ms.exceptions.TransactionInvalidDataExpetion;

import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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

    @PostMapping("/Transaction/{idUser}")
    Transaction newTransaction(@RequestBody Transaction transaction, @PathVariable int idUser) {

        Transaction transactionR = transactionRepository.findById(transaction.getId()).orElse(null);
        AccountB account = accountRepository.findById(idUser).orElse(null);
        BookR book = bookRRepository.findById(transaction.getIdBookR()).orElse(null);

        if (account == null)
            throw new AccountBNotFoundException("Account not found");

        if (book == null)
            throw new BookRNotFoundException("Book not found");

        if (book.getUnits() < transaction.getCount())
            throw new InsufficientUnitsException("Not enough units in stock");

        if (transactionR != null){
            throw new TransactionInvalidDataExpetion("Transaction_id already exists");
        }
        else{
            account.setCount(account.getCount() + transaction.getCount());
            accountRepository.save(account);

            book.setUnits(book.getUnits() - transaction.getCount());
            bookRRepository.save(book);

            transaction.setDate(new Date());
            return transactionRepository.save(transaction);
        }
    }

    @GetMapping("/Transaction/list/{idUser}")
    List<Transaction> getUserTransactions(@PathVariable int idUser){
        AccountB account = accountRepository.findById(idUser).orElse(null);
        if (account == null)
            throw new AccountBNotFoundException("User account not found");
        else{
            List<Transaction> transactions = transactionRepository.findByIdUser(idUser);
            return transactions;
        }
    }

    @DeleteMapping("/Transaction/delete/{idTransaction}")
    String deleteTransaction(@PathVariable int idTransaction){
        Transaction transaction = transactionRepository.findById(idTransaction).orElse(null);
        if (transaction == null){
            throw new TransactionInvalidDataExpetion("Transaction not found");
        }else {
            transactionRepository.delete(transaction);
            return "successful deletion";
        }
    }
}
