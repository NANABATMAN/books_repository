package com.softserve.books_repository_api.controller;

import com.softserve.books_repository_api.dto.AuthorDto;
import com.softserve.books_repository_api.dto.BaseAuthorDto;
import com.softserve.books_repository_api.dto.BookDto;
import com.softserve.books_repository_api.entity.Author;
import com.softserve.books_repository_api.entity.Book;
import com.softserve.books_repository_api.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Илья on 04.10.2016.
 *
 */
@RestController
public class AuthorController {

    @Autowired
    ConversionService conversionService;

    @Autowired
    AuthorService authorService;

    @RequestMapping(value = "/authors", method = RequestMethod.POST)
    public void create(@Valid @RequestBody BaseAuthorDto baseAuthorDto) {
        Author author = conversionService.convert(baseAuthorDto, Author.class);
        authorService.save(author);
    }

    @RequestMapping(value = "/authors/{id}", method = RequestMethod.PUT)
    public BaseAuthorDto update(@Valid @RequestBody BaseAuthorDto baseAuthorDto,
                                @PathVariable("id") long id) {
        Author author = conversionService.convert(baseAuthorDto, Author.class);
        return conversionService.convert(authorService.update(author, id), BaseAuthorDto.class);
    }

    @RequestMapping(value = "/authors/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") long id) {
        authorService.delete(id);
    }

    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    public List<BaseAuthorDto> read(@RequestParam(value = "name", required = false) String name) {
        if (name != null && !name.isEmpty()) {
            return Arrays.asList(conversionService.convert(authorService.findByName(name), BaseAuthorDto[].class));
        }
        return Arrays.asList(conversionService.convert(authorService.findAll(), BaseAuthorDto[].class));
    }

    @RequestMapping(value = "/authors/{id}", method = RequestMethod.GET)
    public BaseAuthorDto read(@PathVariable("id") long id) {
        return conversionService.convert(authorService.findOne(id), BaseAuthorDto.class);
    }

    @RequestMapping(value = "/authors/{id}/books", method = RequestMethod.POST)
    public void createBook(@Valid @RequestBody BookDto bookDto,
                           @PathVariable("id") long id) {
        Author author = authorService.findOne(id);
        Book book = conversionService.convert(bookDto, Book.class);
        authorService.saveBook(author, book);
    }

    @RequestMapping(value = "/authors/{author_id}/books/{book_id}", method = RequestMethod.PUT)
    public AuthorDto updateBook(@Valid @RequestBody BookDto bookDto,
                                @PathVariable("author_id") long authorId,
                                @PathVariable("book_id") long bookId) {
        Author author = authorService.findOne(authorId);
        Book book = conversionService.convert(bookDto, Book.class);
        Author notDeepCopy = authorService.findOneBook(authorService.updateBook(author, book, bookId), bookId);
        return conversionService.convert(notDeepCopy, AuthorDto.class);
//        return conversionService.convert(authorService.updateBook(author, book, bookId), AuthorDto.class);
    }

    @RequestMapping(value = "/authors/{author_id}/books/{book_id}", method = RequestMethod.DELETE)
    public void deleteBook(@PathVariable("author_id") long authorId,
                           @PathVariable("book_id") long bookId) {
        Author author = authorService.findOne(authorId);
        authorService.deleteBook(author, bookId);
    }

    @RequestMapping(value = "/authors/{author_id}/books", method = RequestMethod.GET)
    public AuthorDto readAllBooks(@PathVariable("author_id") long authorId) {
        Author author = authorService.findOne(authorId);
        return conversionService.convert(author, AuthorDto.class);
    }

    @RequestMapping(value = "/authors/{author_id}/books/{book_id}", method = RequestMethod.GET)
    public AuthorDto readBookById(@PathVariable("author_id") long authorId,
                                @PathVariable("book_id") long bookId) {
        Author author = authorService.findOne(authorId);
        Author notDeepCopy = authorService.findOneBook(author, bookId);
        return conversionService.convert(notDeepCopy, AuthorDto.class);
    }

}