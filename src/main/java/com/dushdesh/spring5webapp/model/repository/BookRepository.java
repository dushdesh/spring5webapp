package com.dushdesh.spring5webapp.model.repository;

import com.dushdesh.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
