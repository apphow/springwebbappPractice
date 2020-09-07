package com.april.springwebbapp.domainormodel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String title;
    private String isbn;

    @ManyToOne //Many publisher going to one entity (book)
    private Publisher publisher;

     //we'll have a table for book and author in our db, so we use a join table
   /* @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"),
       inverseJoinColumns = @JoinColumn(name ="author_id"))
       // this holds the relationship in the author and book table
    */
     @ManyToMany
     private Set<Author> authors = new HashSet<>();

    public Book() {
    }

    public Book(String title, String isbn /*,Set<Author> authors*/) {
        this.title = title;
        this.isbn = isbn;
        //this.authors = authors;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publisher=" + publisher +
                ", authors=" + authors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return id != null ? id.equals(book.id) : book.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}