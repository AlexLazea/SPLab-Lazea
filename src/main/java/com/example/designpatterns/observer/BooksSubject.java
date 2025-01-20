package com.example.designpatterns.observer;

import com.example.designpatterns.models.Book;

import java.util.ArrayList;
import java.util.List;

public class BooksSubject implements Subject<Book> {

    private static BooksSubject instance;
    private List<Observer<Book>> observerCollection = new ArrayList<>();

    private BooksSubject(){

    }

    public static BooksSubject getInstance() {
        if (instance == null) {
            instance = new BooksSubject();
        }
        return instance;
    }


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
