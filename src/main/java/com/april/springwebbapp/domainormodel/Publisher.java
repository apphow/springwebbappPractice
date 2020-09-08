package com.april.springwebbapp.domainormodel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String addessLine1;
    private String city;
    private String state;
    private String zip;
    private String publisherName;


    @OneToMany// the publisher is one and it has many books
    @JoinColumn(name = "publisher_id")// giving hibernate a hint to add publisher id to book record to track the publisher
    private Set<Book> books = new HashSet<>();

    public Publisher() {
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisher) {
        this.publisherName = publisher;
    }


    public String getAddessLine1() {
        return addessLine1;
    }

    public void setAddessLine1(String addessLine1) {
        this.addessLine1 = addessLine1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", addessLine1='" + addessLine1 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", publisherName='" + publisherName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;

        return id != null ? id.equals(publisher.id) : publisher.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}