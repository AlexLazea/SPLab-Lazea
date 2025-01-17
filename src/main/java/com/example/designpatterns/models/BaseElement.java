package com.example.designpatterns.models;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) // Moștenire JPA
@NoArgsConstructor(force = true) // Constructor implicit necesar pentru JPA
public abstract class BaseElement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Generare automată pentru ID
    private Long id;

    public abstract void print();

    // Getter și setter pentru ID (opțional)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
