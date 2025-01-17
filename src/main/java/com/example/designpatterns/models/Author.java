package com.example.designpatterns.models;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity // Marchează clasa ca entitate JPA
@NoArgsConstructor(force = true) // Generează un constructor fără parametri (obligatoriu pentru JPA)
public class Author {

    @Id // Marchează acest câmp ca fiind cheia primară
    @GeneratedValue(strategy = GenerationType.AUTO) // Delegă generarea ID-ului către baza de date
    private Long id;

    private String name;
    private String surname;

    public Author(String name) {
        this.name = name;
        this.surname = "";
    }

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void print() {
        System.out.println("Author: " + name + " " + surname);
    }

    // Getter și setter pentru câmpurile private (opțional)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
