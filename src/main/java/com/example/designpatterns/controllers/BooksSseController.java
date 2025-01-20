package com.example.designpatterns.controllers;

import com.example.designpatterns.observer.BooksSubject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import com.example.designpatterns.observer.SseObserver;

@RestController
public class BooksSseController {

    private final BooksSubject allBooksSubject = BooksSubject.getInstance();

    @RequestMapping("/books-sse")
    public ResponseBodyEmitter getBooksSse() {
        final SseEmitter emitter = new SseEmitter(0L);
        allBooksSubject.attach(new SseObserver(emitter));
        return emitter;
    }

}
