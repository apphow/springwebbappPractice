package com.april.springwebbapp.bootstrap;

import com.april.springwebbapp.domainormodel.Author;
import com.april.springwebbapp.domainormodel.Book;
import com.april.springwebbapp.domainormodel.Publisher;
import com.april.springwebbapp.repositories.AuthorRepository;
import com.april.springwebbapp.repositories.BookRepository;
import com.april.springwebbapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setAddessLine1("1234 Main St.");
        publisher.setPublisherName("SFG Publishing");
        publisher.setCity("San Francisco");
        publisher.setState("CA");
        publisher.setZip("94320");

        publisherRepository.save(publisher);

        Publisher publisher1 = new Publisher();
        publisher1.setAddessLine1("Main St.");
        publisher1.setPublisherName("XYZ");
        publisher1.setCity("Martinez");
        publisher1.setState("CA");
        publisher1.setZip("94553");

        Publisher publisher2 = new Publisher();
        publisher2.setAddessLine1("Pier 49");
        publisher2.setPublisherName("ABC Publisher");
        publisher2.setCity("San Francisco");
        publisher2.setState("CA");
        publisher2.setZip("94321");
        publisherRepository.save(publisher2);

        publisherRepository.save(publisher1);
        System.out.println("Publisher Count: " + publisherRepository.count());


        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher1);
        publisher1.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher1);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "45454545");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher2);
        publisher2.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher2);


        Author rylee = new Author("Rylee", "Howard");
        Book cats = new Book("Cats Play", "12345678");
        rylee.getBooks().add(cats);
        cats.getAuthors().add(rylee);

        cats.setPublisher(publisher1);
        publisher1.getBooks().add(cats);

        authorRepository.save(rylee);
        bookRepository.save(cats);
        publisherRepository.save(publisher1);

        Author parker = new Author("Parker", "Howard");
        Book cs = new Book("CS150", "12344444");
        parker.getBooks().add(cs);
        cats.getAuthors().add(parker);

        cats.setPublisher(publisher2);
        publisher2.getBooks().add(cs);

        authorRepository.save(parker);
        bookRepository.save(cs);
        publisherRepository.save(publisher2);

        Author cameron = new Author("Cameron", "Howard");
        Book riches = new Book("Managing Wealth", "48484848");
        cameron.getBooks().add(riches);
        riches.getAuthors().add(cameron);

        riches.setPublisher(publisher);
        publisher.getBooks().add(riches);

        authorRepository.save(cameron);
        bookRepository.save(riches);
        publisherRepository.save(publisher);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());
    }
}
