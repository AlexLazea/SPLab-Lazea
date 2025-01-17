package com.example.designpatterns.models;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity // Marchează clasa ca entitate JPA
@NoArgsConstructor(force = true) // Generează constructor implicit necesar JPA
public class Book implements Element {

    @Id // Cheia primară a entității
    @GeneratedValue(strategy = GenerationType.AUTO) // Generarea automată a valorilor ID-ului
    private Long id;

    private String title;

    @ManyToMany(cascade = CascadeType.ALL) // Relație many-to-many cu Author
    @JoinTable(
            name = "book_author", // Numele tabelei intermediare
            joinColumns = @JoinColumn(name = "book_id"), // Coloana care mapează Book
            inverseJoinColumns = @JoinColumn(name = "author_id") // Coloana care mapează Author
    )
    private List<Author> authors = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, targetEntity = BaseElement.class) // Relație one-to-many cu Element
    private List<Element> content = new ArrayList<>();

    public Book(String title) {
        this.title = title;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addContent(Element element) {
        content.add(element);
    }

    @Override
    public void print() {
        System.out.println("Book: " + title);
        System.out.println("Authors:");
        for (Author author : authors) {
            author.print();
        }
        System.out.println("Content:");
        for (Element e : content) {
            e.print();
        }
    }

    // Getter și setter pentru câmpuri private (opțional)
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

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Element> getContent() {
        return content;
    }

    public void setContent(List<Element> content) {
        this.content = content;
    }
}
