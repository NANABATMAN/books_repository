package com.softserve.books_repository_api.repository;

import com.softserve.books_repository_api.entity.Book;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by ikar on 28.09.2016.
 *
 */
@Transactional
public interface BookRepository extends CrudRepository <Book, Long> {
}