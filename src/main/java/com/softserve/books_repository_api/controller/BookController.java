package com.softserve.books_repository_api.controller;

import com.softserve.books_repository_api.dto.BaseBookDto;
import com.softserve.books_repository_api.dto.BookDto;
import com.softserve.books_repository_api.entity.Book;
import com.softserve.books_repository_api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.Arrays;

/**
 * Created by ikar on 28.09.2016.
 *
 */
@RestController
public class BookController {

    @Autowired
    ConversionService conversionService;

    @Autowired
    BookService bookService;

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public void create(@Valid @RequestBody BookDto bookDto) {
        Book newBook = conversionService.convert(bookDto, Book.class);
        bookService.save(newBook);
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public Object read(@RequestParam(value = "id", required = false) Long id,
                       @RequestParam(value = "author", required = false) String author) throws Exception {
        if (id != null && author != null && !author.isEmpty()) {
            throw new Exception("Only one request param can be used!");
        }
        if (id != null) {
            return conversionService.convert(bookService.findById(id), BookDto.class);
        }
        if (author != null && !author.isEmpty()) {
            return Arrays.asList(conversionService.convert(bookService.findByAuthor(author), BookDto[].class));
        }
        return Arrays.asList(conversionService.convert(bookService.findAll(), BaseBookDto[].class));
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.PUT)
    public void update(@Valid @RequestBody BookDto bookDto, @PathVariable("id") long id) throws EntityNotFoundException {
        bookService.update(bookDto, id);
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") long id) throws EntityNotFoundException {
        bookService.delete(id);
    }

}