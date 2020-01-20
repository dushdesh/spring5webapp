package com.dushdesh.spring5webapp.model.repository;

import com.dushdesh.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
