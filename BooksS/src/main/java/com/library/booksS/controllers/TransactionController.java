package com.library.booksS.controllers;

import com.library.booksS.exceptions.InsufficientUnitsException;
import com.library.booksS.repositories.AccountRepository;
import com.library.booksS.models.AccountB;
import com.library.booksS.exceptions.AccountBNotFoundException;
import com.library.booksS.repositories.BookSRepository;
import com.library.booksS.models.BookS;
import com.library.booksS.exceptions.BookSNotFoundException;
import com.library.booksS.repositories.TransactionRepository;
import com.library.booksS.models.Transaction;
import com.library.booksS.exceptions.InsufficientBalanceException;

import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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

    @PostMapping("/Transaction")
    Transaction newTransaction(@RequestBody Transaction transaction) {

        AccountB account = accountRepository.findById(transaction.getIdUser()).orElse(null);
        BookS book = bookSRepository.findById(transaction.getIdBookS()).orElse(null);

        if (account == null)
            throw new AccountBNotFoundException("No se encontro una cuenta con el id: " + transaction.getIdUser());

        if (book == null)
            throw new BookSNotFoundException("No se encontro un libro con el id: " + transaction.getIdBookS());

        if (account.getBalance() < book.getPrice() * transaction.getCount())
            throw new InsufficientBalanceException("Saldo Insuficiente");

        if (book.getUnits() < transaction.getCount())
            throw new InsufficientUnitsException("Unidades Insuficientes");

        account.setBalance(account.getBalance() - book.getPrice() * transaction.getCount());
        accountRepository.save(account);

        book.setUnits(book.getUnits() - transaction.getCount());
        bookSRepository.save(book);

        transaction.setValue(book.getPrice() * transaction.getCount());
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
