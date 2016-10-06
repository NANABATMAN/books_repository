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

    public Author updateBook(Author author, Book book, long bookId) {
        if (!bookRepository.exists(bookId)) {
            throw new EntityNotFoundException("A book with id - " + bookId + " does not exist in database!");
        }
        if (!author.getBooks().contains(bookRepository.findOne(bookId))) {
            throw new EntityNotFoundException("Book with id - " + bookId + " does not belong to the author - " + author.getName() + "!");
        }
        book.setId(bookId);
        bookRepository.save(book);
        return author;
    }

    public void deleteBook(Author author, long bookId) {
        if (!bookRepository.exists(bookId)) {
            throw new EntityNotFoundException("A book with id - " + bookId + " does not exist in database!");
        }
        Set<Book> bookSet = author.getBooks();
        if (!bookSet.contains(bookRepository.findOne(bookId))) {
            throw new EntityNotFoundException("Book with id - " + bookId + " does not belong to the author - " + author.getName() + "!");
        }
        bookSet.remove(bookRepository.findOne(bookId));
        bookRepository.delete(bookId);
    }

    public Author findOneBook(Author author, long bookId) {
        if (!bookRepository.exists(bookId)) {
            throw new EntityNotFoundException("A book with id - " + bookId + " does not exist in database!");
        }
        Book book = bookRepository.findOne(bookId);
        if (!author.getBooks().contains(book)) {
            throw new EntityNotFoundException("Book with id - " + bookId + " does not belong to the author - " + author.getName() + "!");
        }
        Author copy = notDeepCopy(author);
        copy.getBooks().add(book);
        return copy;
    }

    private Author notDeepCopy(Author author) {
        Author copy = new Author();
        copy.setId(author.getId());
        copy.setName(author.getName());
        copy.setYear(author.getYear());
        return copy;
    }

}