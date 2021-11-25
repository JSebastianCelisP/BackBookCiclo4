package com.LibreriaRentalApp.Rental_ms.controllers;

import com.LibreriaRentalApp.Rental_ms.repositories.AccountRepository;
import com.LibreriaRentalApp.Rental_ms.models.AccountB;
import com.LibreriaRentalApp.Rental_ms.exceptions.AccountBNotFoundException;
import com.LibreriaRentalApp.Rental_ms.repositories.BookRRepository;
import com.LibreriaRentalApp.Rental_ms.models.BookR;
import com.LibreriaRentalApp.Rental_ms.exceptions.BookRNotFoundException;
import com.LibreriaRentalApp.Rental_ms.repositories.TransactionRepository;
import com.LibreriaRentalApp.Rental_ms.models.Transaction;
import com.LibreriaRentalApp.Rental_ms.exceptions.InsufficientBalanceException;
import com.LibreriaRentalApp.Rental_ms.exceptions.InsufficientUnitsException;
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

    @PostMapping("/Transaction")
    Transaction newTransaction(@RequestBody Transaction transaction) {

        AccountB account = accountRepository.findById(transaction.getIdUser()).orElse(null);
        BookR book = bookRRepository.findById(transaction.getIdBookR()).orElse(null);

        if (account == null)
            throw new AccountBNotFoundException("No se encontro una cuenta con el id: " + transaction.getIdUser());

        if (book == null)
            throw new BookRNotFoundException("No se encontro un libro con el id: " + transaction.getIdBookR());

        if (account.getBalance() < transaction.getTime() * 2000)
            throw new InsufficientBalanceException("Saldo Insuficiente");

        if (book.getUnits() <= 0)
            throw new InsufficientUnitsException("Unidades Insuficientes");

        account.setBalance(account.getBalance() - transaction.getTime() * 2000);
        accountRepository.save(account);

        book.setUnits(book.getUnits() - 1);
        bookRRepository.save(book);

        transaction.setValue(transaction.getTime() * 2000);
        transaction.setDate(new Date());
        return transactionRepository.save(transaction);
    }

    @GetMapping("/Transaction/list/{idUser}")
    List<Transaction> getUserTransactions(@PathVariable int idUser){
        AccountB account = accountRepository.findById(idUser).orElse(null);
        if (account == null)
            throw new AccountBNotFoundException("No se encontro una cuenta con el id: " + idUser);

        List<Transaction> transactions = transactionRepository.findByIdUser(idUser);

        return transactions;
    }

    @DeleteMapping("/Transaction/delete")
    void deleteTransaction(@RequestBody Transaction transaction){
        transactionRepository.delete(transaction);
        return;
    }

}
