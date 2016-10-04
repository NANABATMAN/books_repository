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
import java.util.List;

/**
 * Created by ikar on 28.09.2016.
 *
 */
@RestController
public class BookController {

//    @Autowired
//    ConversionService conversionService;
//
//    @Autowired
//    BookService bookService;
//
//    @RequestMapping(value = "/books", method = RequestMethod.POST)
//    public void create(@Valid @RequestBody BookDto bookDto) {
//        Book newBook = conversionService.convert(bookDto, Book.class);
//        bookService.save(newBook);
//    }
//
//    @RequestMapping(value = "/books", method = RequestMethod.GET)
//    public List<BaseBookDto> read() {
//        Iterable<Book> bookList = bookService.findAll();
//        return Arrays.asList(conversionService.convert(bookList, BaseBookDto[].class));
//    }
//
//    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
//    public BookDto read(@PathVariable("id") long id) {
//        Book book = bookService.findById(id);
//        return conversionService.convert(book, BookDto.class);
//    }
//
//    @RequestMapping(value = "/books/{id}", method = RequestMethod.PUT)
//    public void update(@Valid @RequestBody BookDto bookDto, @PathVariable("id") long id) throws EntityNotFoundException {
//        Book book = conversionService.convert(bookDto, Book.class);
//        bookService.update(book, id);
//    }
//
//    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
//    public void delete(@PathVariable("id") long id) throws EntityNotFoundException {
//        bookService.delete(id);
//    }

}