package com.library.booksS.controllers;

import com.library.booksS.repositories.BookSRepository;
import com.library.booksS.models.BookS;
import com.library.booksS.exceptions.BookSAlreadyExistsException;
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
                .orElseThrow(() -> new BookSNotFoundException("Book not found"));
    }

    @GetMapping("/Books/title/{title}")
    BookS getBookByName(@PathVariable String title){
        BookS book = null;
        book = bookSRepository.findByTitle(title);

        if (book == null){
            throw new BookSNotFoundException("Book not found");
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
        BookS bookR = bookSRepository.findById(book.getIdBookS()).orElse(null);
        if(bookR != null){
            throw new BookSAlreadyExistsException("Book already exists");
        }else{
            return bookSRepository.save(book);
        }
    }

    @PostMapping("/Books/update/{idBookS}")
    BookS updateBook(@RequestBody BookS book, @PathVariable int idBookS ){
        if(book.getIdBookS() != idBookS){
            throw new BookSNotFoundException("Invalid credential");            
        }else{
            return bookSRepository.save(book);
        }
    }

    @DeleteMapping ("/Books/delete/{idBookS}")
    void deleteBook(@RequestBody BookS book, @PathVariable int idBookS){
        if(book.getIdBookS() != idBookS){
            throw new BookSNotFoundException("Invalid credential");
        }else{
            bookSRepository.delete(book);
        }
    }
}
