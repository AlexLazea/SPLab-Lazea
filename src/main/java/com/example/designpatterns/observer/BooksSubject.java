package com.example.designpatterns.observer;

import com.example.designpatterns.models.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BooksSubject implements Subject<Book> {


    private List<Observer<Book>> observerCollection = new ArrayList<>();



    public void attach(Observer<Book> observer){
        observerCollection.add(observer);

    }

    @Override
    public void detach(Observer<Book> observer) {
        observerCollection.remove(observer);
    }

    @Override
    public void notifyObservers(Book data) {
        for (Observer<Book> observer : observerCollection){
            observer.update(data);
        }
    }

    public void add(Book book){
        notifyObservers(book);
    }

}
