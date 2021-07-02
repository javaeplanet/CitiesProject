package com.example.CitiesProject.CitiesProject.repos;

import com.example.CitiesProject.CitiesProject.model.Book;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BookRepository extends ReactiveCrudRepository<Book,Integer> {
}
