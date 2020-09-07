package com.april.springwebbapp.repositories;

import com.april.springwebbapp.domainormodel.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
