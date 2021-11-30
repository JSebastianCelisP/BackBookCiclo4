package com.library.booksS.repositories;

import com.library.booksS.models.BookS;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookSRepository extends MongoRepository<BookS, Object> {
    BookS findByTitle (String title);
}
