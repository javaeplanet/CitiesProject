package com.example.CitiesProject.CitiesProject.controller;

import com.example.CitiesProject.CitiesProject.model.Book;
import com.example.CitiesProject.CitiesProject.repos.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookRepository repository;

    @PostMapping("/addBook")
    public String saveBook(@RequestBody Book book){
        repository.save(book);
        return "Added book with id:"+book.getId();
    }

    @GetMapping("/findAllBooks")
    public List<Book> getBooks(){
        return repository.findAll();
    }
@GetMapping("/findAllBooks/{id}")
    public Book getBookById( @PathVariable("id") Integer id){
        return repository.findById(id).get();
    }
    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id")  Integer id){
         repository.deleteById(id);
        return "book deleted with id:"+id;
    }
}
