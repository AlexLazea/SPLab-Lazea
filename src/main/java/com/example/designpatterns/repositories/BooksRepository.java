package com.example.designpatterns.repositories;

import com.example.designpatterns.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Book, Integer> {
}