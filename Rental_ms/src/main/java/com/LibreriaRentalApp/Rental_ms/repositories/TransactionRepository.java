package com.LibreriaRentalApp.Rental_ms.repositories;

import com.LibreriaRentalApp.Rental_ms.models.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TransactionRepository extends MongoRepository<Transaction, Integer> {
    List<Transaction> findByIdUser(int idUser);
}
