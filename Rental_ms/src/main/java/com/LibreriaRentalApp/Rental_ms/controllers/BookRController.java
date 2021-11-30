package com.LibreriaRentalApp.Rental_ms.controllers;

import com.LibreriaRentalApp.Rental_ms.exceptions.BookRAlreadyExistsException;
import com.LibreriaRentalApp.Rental_ms.exceptions.BookRNotFoundException;
import com.LibreriaRentalApp.Rental_ms.models.BookR;
import com.LibreriaRentalApp.Rental_ms.repositories.BookRRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookRController {
    private final BookRRepository bookRRepository;

    public BookRController(BookRRepository bookRRepository) {
        this.bookRRepository = bookRRepository;
    }

    @GetMapping("/Books/id/{idBook}")
    BookR getBookById(@PathVariable int idBook){
        return bookRRepository.findById(idBook)
                .orElseThrow(() -> new BookRNotFoundException("Book not found"));
    }

    @GetMapping("/Books/title/{title}")
    BookR getBookByName(@PathVariable String title){
        BookR book = null;
        book = bookRRepository.findByTitle(title);

        if (book == null){
            throw new BookRNotFoundException("Book not found");
        }
        return book;
    }

    @GetMapping("/Books/list")
    List<BookR> getBooks(){
        List<BookR> books = bookRRepository.findAll();
        return books;
    }

    @PostMapping("/Books")
    BookR newBook(@RequestBody BookR book){
        BookR bookR = bookRRepository.findById(book.getIdBookR()).orElse(null);
        if(bookR != null){
            throw new BookRAlreadyExistsException("Book already exists");
        }else{
            return bookRRepository.save(book);
        }
    }

    @PostMapping("/Books/update/{idBookR}")
    BookR updateBook(@RequestBody BookR book, @PathVariable int idBookR){
        if(book.getIdBookR() != idBookR){
            throw new BookRNotFoundException("Invalid credential");            
        }else{
            return bookRRepository.save(book);
        }
    }

    @DeleteMapping("/Books/delete/{idBookR}")
    void deleteBook(@RequestBody BookR book, @PathVariable int idBookR){
        if(book.getIdBookR() != idBookR){
            throw new BookRNotFoundException("Invalid credential");
        }else{
            bookRRepository.delete(book);
        }
    }
}
