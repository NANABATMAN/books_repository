package com.softserve.books_repository_api.service.impl;

import com.softserve.books_repository_api.entity.Author;
import com.softserve.books_repository_api.repository.AuthorRepository;
import com.softserve.books_repository_api.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

/**
 * Created by Илья on 04.10.2016.
 *
 */
@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public void save(Author author) {
        authorRepository.save(author);
    }

    public Author update(Author author, long id) throws EntityNotFoundException {
        if (!authorRepository.exists(id)) {
            throw new EntityNotFoundException("An author with id - " + id + " does not exist in database!");
        }
        author.setId(id);
        save(author);
        return author;
    }

    public void delete(long id) throws EntityNotFoundException {
        if (!authorRepository.exists(id)) {
            throw new EntityNotFoundException("An author with id - " + id + " does not exist in database!");
        }
        authorRepository.delete(id);
    }

}