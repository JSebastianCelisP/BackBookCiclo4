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
    BookS updateBook(@RequestBody BookS bookUpdate, @PathVariable int idBookS ){
        BookS book = bookSRepository.findById(idBookS).orElse(null);
        if(book == null){
            throw new BookSNotFoundException("Book not found");
        }else{
            return bookSRepository.save(bookUpdate);
        }
    }

    @DeleteMapping ("/Books/delete/{idBookS}")
    String deleteBook(@PathVariable int idBookS){
        BookS book = bookSRepository.findById(idBookS).orElse(null);
        if(book == null){
            throw new BookSNotFoundException("book not found");
        }else{
            bookSRepository.deleteById(idBookS);
            return "successful deletion";
        }
    }
}
