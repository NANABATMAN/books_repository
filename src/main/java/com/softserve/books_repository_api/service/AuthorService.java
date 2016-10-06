package com.softserve.books_repository_api.service;

import com.softserve.books_repository_api.entity.Author;
import com.softserve.books_repository_api.entity.Book;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Set;

/**
 * Created by Илья on 04.10.2016.
 *
 */
public interface AuthorService {

    void save(Author author);

    Author update(Author author, long id) throws EntityNotFoundException;

    void delete(long id) throws EntityNotFoundException;

    Iterable<Author> findAll();

    List<Author> findByName(String name) throws EntityNotFoundException;

    Author findOne(long id) throws EntityNotFoundException;

    void saveBook(Author author, Book book);

    Author updateBook(Author author, Book book, long bookId) throws EntityNotFoundException;

    void deleteBook(Author author, long bookId) throws EntityNotFoundException;

    Author findOneBook(Author author, long bookId) throws EntityNotFoundException;

}