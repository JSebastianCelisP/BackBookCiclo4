package com.library.booksS.repositories;

import com.library.booksS.models.AccountB;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<AccountB, Integer> {
}
