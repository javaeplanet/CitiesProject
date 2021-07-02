package com.example.CitiesProject.CitiesProject.controller;

import com.example.CitiesProject.CitiesProject.model.Book;
import com.example.CitiesProject.CitiesProject.repos.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

@RestController
public class BookController {

    @Autowired
    private BookRepository repository;

    @PostMapping("/addBook")
    public Mono<Book> saveBook(@RequestBody Book book){
      return   repository.save(book);
    }

//    @GetMapping("/findAllBooks")
//    public List<Book> getBooks(){
//        return repository.findAll();
//    }

    @GetMapping("/books")
    public Flux<Book> getAllBooks(){
        return repository.findAll();
    }

@GetMapping("/findAllBooks/{id}")
    public Mono<Book> getBookById(@PathVariable("id") Integer id){
        return repository.findById(id);
    }
    @DeleteMapping("/delete/{id}")
    public Mono<Book> deleteBook(@PathVariable("id")  Integer id){
        Mono<Void> book = repository.deleteById(id);
        if(Objects.isNull(book)){
            return Mono.empty();
        }
        return getBookById(id).switchIfEmpty(Mono.empty()).filter(Objects::nonNull).flatMap(studentToBeDeleted->
                repository.delete(studentToBeDeleted).then(Mono.just(studentToBeDeleted)));
    }

    @PutMapping("/update")
    public  Mono<Book> UpdateBook(  @RequestBody Book book){
        return repository.save(book);
    }
}
