package com.dushdesh.spring5webapp.bootstrap;

import com.dushdesh.spring5webapp.model.Author;
import com.dushdesh.spring5webapp.model.Book;
import com.dushdesh.spring5webapp.model.Publisher;
import com.dushdesh.spring5webapp.model.repository.AuthorRepository;
import com.dushdesh.spring5webapp.model.repository.BookRepository;
import com.dushdesh.spring5webapp.model.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    @Autowired
    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        Author eric = new Author("Eric", "Evans");
        Publisher pub1 = new Publisher("Harper Collins", "123 Dallas Dr, Dallas");
        publisherRepository.save(pub1);
        Book ddd = new Book("Domain Drive Design", "123", pub1);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(ddd);


        Author rod = new Author("Rod", "Johnson");
        Publisher pub2 = new Publisher("Woks", "123 Toronto Dr, Toronto");
        publisherRepository.save(pub2);
        Book noEJB = new Book("J2EE without EJB", "345", pub2);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(pub2);
    }
}
