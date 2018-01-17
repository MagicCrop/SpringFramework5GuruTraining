package com.mkalisvaart.spring5webapp.repositories;

import com.mkalisvaart.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
