package com.softserve.books_repository_api.service;

import com.softserve.books_repository_api.dto.BookDto;
import com.softserve.books_repository_api.entity.Book;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * Created by ikar on 29.09.2016.
 *
 */
public interface BookService {

    void save(Book book);

    void update(Book book, long id) throws EntityNotFoundException;

    void delete(long id) throws EntityNotFoundException;

    Book findById(long id) throws EntityNotFoundException;

    Iterable<Book> findAll();

}