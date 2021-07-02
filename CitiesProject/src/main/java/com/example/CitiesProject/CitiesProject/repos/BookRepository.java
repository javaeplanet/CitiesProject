package com.example.CitiesProject.CitiesProject.repos;

import com.example.CitiesProject.CitiesProject.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book,Integer> {
}
