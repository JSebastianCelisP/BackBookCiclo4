package com.library.booksS.repositories;

import com.library.booksS.models.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface TransactionRepository extends MongoRepository<Transaction, Integer> {
    List<Transaction> findByIdUser(int idUser);
}
