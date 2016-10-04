package com.softserve.books_repository_api.service;

import com.softserve.books_repository_api.entity.Author;

import javax.persistence.EntityNotFoundException;

/**
 * Created by Илья on 04.10.2016.
 *
 */
public interface AuthorService {

    public void save(Author author);

    public Author update(Author author, long id) throws EntityNotFoundException;

    public void delete(long id) throws EntityNotFoundException;

}