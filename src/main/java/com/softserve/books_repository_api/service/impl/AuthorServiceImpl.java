package com.softserve.books_repository_api.service.impl;

import com.softserve.books_repository_api.entity.Author;
import com.softserve.books_repository_api.entity.Book;
import com.softserve.books_repository_api.repository.AuthorRepository;
import com.softserve.books_repository_api.repository.BookRepository;
import com.softserve.books_repository_api.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Set;

/**
 * Created by Илья on 04.10.2016.
 *
 */
@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    public void save(Author author) {
        authorRepository.save(author);
    }

    public Author update(Author author, long id) {
        if (!authorRepository.exists(id)) {
            throw new EntityNotFoundException("An author with id - " + id + " does not exist in database!");
        }
        author.setId(id);
        save(author);
        return author;
    }

    public void delete(long id) {
        if (!authorRepository.exists(id)) {
            throw new EntityNotFoundException("An author with id - " + id + " does not exist in database!");
        }
        authorRepository.delete(id);
    }

    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }

    public List<Author> findByName(String name) {
        List<Author> authorList = authorRepository.findByName(name);
        if (authorList.size() == 0) {
            throw new EntityNotFoundException("An author with name - " + name + " does not exist in database!");
        }
        return authorList;
    }

    public Author findOne(long id) {
        if (!authorRepository.exists(id)) {
            throw new EntityNotFoundException("An author with id - " + id + " does not exist in database!");
        }
        return authorRepository.findOne(id);
    }

    public void saveBook(Author author, Book book) {
        author.getBooks().add(book);
        bookRepository.save(book);
    }

    public Book updateBook(Author author, Book book, long bookId) {
        if (!bookRepository.exists(bookId)) {
            throw new EntityNotFoundException("A book with id - " + bookId + " does not exist in database!");
        }
        book.setId(bookId);
        bookRepository.save(book);
        return book;
    }

    public void deleteBook(Author author, long bookId) {
        if (!bookRepository.exists(bookId)) {
            throw new EntityNotFoundException("A book with id - " + bookId + " does not exist in database!");
        }
        author.getBooks().remove(bookRepository.findOne(bookId));
        bookRepository.delete(bookId);
    }

}