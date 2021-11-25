package com.library.booksS.controllers;

import com.library.booksS.repositories.BookSRepository;
import com.library.booksS.models.BookS;
import com.library.booksS.exceptions.BookSNotFoundException;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookSController {
    private final BookSRepository bookSRepository;

    public BookSController(BookSRepository bookSRepository) {
        this.bookSRepository = bookSRepository;
    }

    @GetMapping("/Books/id/{idBook}")
    BookS getBookById(@PathVariable int idBook){
        return bookSRepository.findById(idBook)
                .orElseThrow(() -> new BookSNotFoundException("No se encontro un libro con el id " + idBook));
    }

    @GetMapping("/Books/title/{title}")
    BookS getBookByName(@PathVariable String title){
        BookS book = null;
        book = bookSRepository.findByTitle(title);

        if (book == null){
            throw new BookSNotFoundException("No se encontro un libro con el nombre " + title);
        }
        return book;
    }

    @GetMapping("/Books/list")
    List<BookS> getBooks(){
        List<BookS> books = bookSRepository.findAll();
        return books;
    }

    @PostMapping("/Books")
    BookS newBook(@RequestBody BookS book){
        return bookSRepository.save(book);
    }

    @PostMapping("/Books/update")
    BookS updateBook(@RequestBody BookS book){
        return bookSRepository.save(book);
    }

    @DeleteMapping ("/Books/delete")
    void deleteBook(@RequestBody BookS book){
        bookSRepository.delete(book);
        return;
    }
}
