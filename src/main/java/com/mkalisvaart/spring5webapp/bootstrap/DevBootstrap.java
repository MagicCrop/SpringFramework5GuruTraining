package com.mkalisvaart.spring5webapp.bootstrap;

import com.mkalisvaart.spring5webapp.model.Author;
import com.mkalisvaart.spring5webapp.model.Book;
import com.mkalisvaart.spring5webapp.model.Publisher;
import com.mkalisvaart.spring5webapp.repositories.AuthorRepository;
import com.mkalisvaart.spring5webapp.repositories.BookRepository;
import com.mkalisvaart.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;
    
    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }
    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
    
    private void initData() {
        Publisher publisher = new Publisher();
        publisher.setName("Dangerous Books");
        publisher.setAddress("blabla");
        
        publisherRepository.save(publisher);
        
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", publisher);
        Book dd5e = new Book("D&D5e", "12340", publisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        eric.getBooks().add(dd5e);
        dd5e.getAuthors().add(eric);
        
        authorRepository.save(eric);
        bookRepository.save(ddd);
        bookRepository.save(dd5e);
        
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", publisher);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        
        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}