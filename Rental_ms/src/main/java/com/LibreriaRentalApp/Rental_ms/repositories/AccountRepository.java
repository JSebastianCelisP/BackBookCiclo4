package com.LibreriaRentalApp.Rental_ms.repositories;

import com.LibreriaRentalApp.Rental_ms.models.AccountB;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<AccountB, String> {
}
