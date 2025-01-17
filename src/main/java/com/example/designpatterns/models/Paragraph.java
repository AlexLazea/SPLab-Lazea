package com.example.designpatterns.models;

import com.example.designpatterns.services.Strategy;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity // Marchează clasa ca entitate JPA
@NoArgsConstructor(force = true) // Constructor implicit pentru JPA
public class Paragraph extends BaseElement implements Element {

    @Id // Cheia primară a entității
    @GeneratedValue(strategy = GenerationType.AUTO) // Generare automată pentru ID
    private Long id;

    private String text;

    @Transient // Exclude câmpul textAlignment de la persistare
    private Strategy textAlignment;

    public Paragraph(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setStrategy(Strategy strategy) {
        this.textAlignment = strategy;
    }

    public void render(int width) {
        if (textAlignment != null) {
            textAlignment.render(this, width);
        } else {
            System.out.println(text);
        }
    }

    @Override
    public void print() {
        System.out.println("Paragraph: " + text);
    }

    // Getter și setter pentru ID (opțional)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
