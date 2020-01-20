package com.dushdesh.spring5webapp.model.repository;

import com.dushdesh.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
