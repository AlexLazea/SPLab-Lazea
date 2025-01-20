package com.example.designpatterns.config;

import com.example.designpatterns.models.Book;
import com.example.designpatterns.repositories.BooksRepository;
import com.example.designpatterns.repositories.CrudRepository;
import com.example.designpatterns.repositories.CrudRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

    @Bean
    public CrudRepository<Book, Integer> bookCrudRepository(BooksRepository bookRepository) {
        return new CrudRepositoryAdapter<>(bookRepository);
    }
}

