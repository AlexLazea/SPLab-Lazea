package com.example.designpatterns.models;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity // Marchează clasa ca entitate JPA
@NoArgsConstructor(force = true) // Constructor implicit necesar pentru JPA
public class Section extends BaseElement implements Element {

    @Id // Cheia primară a entității
    @GeneratedValue(strategy = GenerationType.AUTO) // Generare automată pentru ID
    private Long id;

    private String title;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) // Relație one-to-many cu Element
    @JoinColumn(name = "section_id") // Asociază elementele cu secțiunea curentă
    private List<BaseElement> elements = new ArrayList<>();

    public Section(String title) {
        this.title = title;
    }

    public void add(BaseElement element) {
        elements.add(element);
    }

    public void remove(BaseElement element) {
        elements.remove(element);
    }

    @Override
    public void print() {
        System.out.println("Section: " + title);
        for (BaseElement e : elements) {
            e.print();
        }
    }

    // Getter și setter pentru ID (opțional)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<BaseElement> getElements() {
        return elements;
    }

    public void setElements(List<BaseElement> elements) {
        this.elements = elements;
    }
}
