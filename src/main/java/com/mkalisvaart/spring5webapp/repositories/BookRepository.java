package com.mkalisvaart.spring5webapp.repositories;

import com.mkalisvaart.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}