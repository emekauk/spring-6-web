package com.js9.spring6webapp.bootstrap;

import com.js9.spring6webapp.domain.Author;
import com.js9.spring6webapp.domain.Book;
import com.js9.spring6webapp.domain.Publisher;
import com.js9.spring6webapp.repository.AuthorRepository;
import com.js9.spring6webapp.repository.BookRepository;
import com.js9.spring6webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataInitializer implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public DataInitializer(AuthorRepository authorRepository,
                           BookRepository bookRepository,
                           PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        var ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        var oop = new Book();
        oop.setTitle("Object Oriented Programming");
        oop.setIsbn("2345667");

        var savedDdd = bookRepository.save(ddd);
        var savedOop = bookRepository.save(oop);

        var rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");
        rod.setEmail("rod-johson@gmail.com");

        var john = new Author();
        john.setFirstName("John");
        john.setLastName("Thompson");
        john.setEmail("john-thompson@gmail.com");

        var publisher1 = new Publisher();
        publisher1.setPublisherName("Publisher1");
        publisher1.setAddress("address1");
        publisher1.setCity("city1");
        publisher1.setState("state1");
        publisher1.setZip("zip1");

        var publisher2 = new Publisher();
        publisher2.setPublisherName("Publisher2");
        publisher2.setAddress("address2");
        publisher2.setCity("city2");
        publisher2.setState("state2");
        publisher2.setZip("zip2");

        var savedPublisher1 = publisherRepository.save(publisher1);
        var savedPublisher2 = publisherRepository.save(publisher2);
        System.out.println(savedPublisher1);
        System.out.println(savedPublisher2);

        savedDdd.setPublisher(savedPublisher1);
        savedOop.setPublisher(savedPublisher2);


        var savedRod = authorRepository.save(rod);
        var savedJohn = authorRepository.save(john);


        savedDdd.getAuthors().add(savedRod);
        savedRod.getBooks().add(savedDdd);

        savedJohn.getBooks().add(savedOop);
        savedOop.getAuthors().add(savedJohn);

        authorRepository.save(savedJohn);
        authorRepository.save(savedRod);

        bookRepository.save(savedDdd);
        bookRepository.save(savedOop);


        System.out.println("Count of books saved in repository = " + bookRepository.count());
        System.out.println("Count of authors saved in repository = " + authorRepository.count());

        System.out.println("count of publisher in repository = "+ publisherRepository.count());



    }
}
