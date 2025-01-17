package com.example.designpatterns.models;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity // Marchează clasa ca entitate JPA
@NoArgsConstructor(force = true) // Generează un constructor implicit necesar JPA
public class Image extends BaseElement implements Element {

    @Id // Cheia primară a entității
    @GeneratedValue(strategy = GenerationType.AUTO) // Generarea automată a valorilor ID-ului
    private Long id;

    private String url;

    public Image(String url) {
        this.url = url;
    }

    @Override
    public void print() {
        System.out.println("Image: " + url);
    }

    // Getter și setter pentru câmpuri private (opțional)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
