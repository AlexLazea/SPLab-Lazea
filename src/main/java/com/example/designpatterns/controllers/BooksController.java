package com.example.designpatterns.controllers;

import com.example.designpatterns.models.Book;
import com.example.designpatterns.observer.BooksSubject;
import com.example.designpatterns.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BooksRepository booksRepository;

    private final BooksSubject allBooksSubject = BooksSubject.getInstance();

    @Autowired
    public BooksController(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return booksRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable Integer id) {
        return booksRepository.findById(id);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        allBooksSubject.add(book);
        return booksRepository.save(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Integer id, @RequestBody Book bookDetails) {
        return booksRepository.findById(id).map(book -> {
            book.setTitle(bookDetails.getTitle());
            book.setAuthors(bookDetails.getAuthors());
            return booksRepository.save(book);
        }).orElseThrow(() -> new RuntimeException("Book not found with id " + id));
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Integer id) {
        booksRepository.deleteById(id);
        return "Book with ID " + id + " deleted";
    }
}
