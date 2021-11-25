package com.LibreriaRentalApp.Rental_ms.repositories;

import com.LibreriaRentalApp.Rental_ms.models.BookR;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRRepository extends MongoRepository<BookR, Integer> {
    BookR findByTitle (String title);
}
