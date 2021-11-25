package com.LibreriaRentalApp.Rental_ms.controllers;

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
                .orElseThrow(() -> new BookRNotFoundException("No se encontro un libro con el id " + idBook));
    }

    @GetMapping("/Books/title/{title}")
    BookR getBookByName(@PathVariable String title){
        BookR book = null;
        book = bookRRepository.findByTitle(title);

        if (book == null){
            throw new BookRNotFoundException("No se encontro un libro con el nombre " + title);
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
        return bookRRepository.save(book);
    }

    @PostMapping("/Books/update")
    BookR updateBook(@RequestBody BookR book){
        return bookRRepository.save(book);
    }

    @DeleteMapping("/Books/delete")
    void deleteBook(@RequestBody BookR book){
        bookRRepository.delete(book);
        return;
    }

}
