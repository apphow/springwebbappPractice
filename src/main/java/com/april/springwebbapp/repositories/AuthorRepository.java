package com.april.springwebbapp.repositories;

import com.april.springwebbapp.domainormodel.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
