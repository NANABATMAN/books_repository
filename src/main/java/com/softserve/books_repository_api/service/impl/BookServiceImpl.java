package com.softserve.books_repository_api.service.impl;

import com.softserve.books_repository_api.entity.Book;
import com.softserve.books_repository_api.repository.BookRepository;
import com.softserve.books_repository_api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

/**
 * Created by ikar on 30.09.2016.
 *
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    public void save(Book book) {
        bookRepository.save(book);
    }

    public void update(Book book, long id) throws EntityNotFoundException {
        Book oldBookInfo = findById(id);
        book.setId(oldBookInfo.getId());
        save(book);
    }

    public void delete(long id) throws EntityNotFoundException {
        if (!bookRepository.exists(id)) {
            throw new EntityNotFoundException("A record with id - " + id + " doesn't exist in the database!");
        }
        bookRepository.delete(id);
    }

    public Book findById(long id) throws EntityNotFoundException {
        Book book = bookRepository.findOne(id);
        if (book == null) {
            throw new EntityNotFoundException("A record with id - " + id + " doesn't exist in the database!");
        }
        return book;
    }

    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

}