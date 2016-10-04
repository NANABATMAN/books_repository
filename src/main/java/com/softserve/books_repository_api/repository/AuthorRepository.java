package com.softserve.books_repository_api.repository;

import com.softserve.books_repository_api.entity.Author;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by Илья on 04.10.2016.
 *
 */
@Transactional
public interface AuthorRepository extends CrudRepository<Author, Long> {
}