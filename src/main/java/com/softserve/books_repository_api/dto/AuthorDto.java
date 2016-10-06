package com.softserve.books_repository_api.dto;

import com.softserve.books_repository_api.entity.Book;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ikar on 06.10.2016.
 *
 */
public class AuthorDto extends BaseAuthorDto {

    private Set<Book> books = new HashSet<>(0);

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

}