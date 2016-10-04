package com.softserve.books_repository_api.controller;

import com.softserve.books_repository_api.dto.AuthorDto;
import com.softserve.books_repository_api.entity.Author;
import com.softserve.books_repository_api.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public void create(@Valid @RequestBody AuthorDto authorDto) {
        Author author = conversionService.convert(authorDto, Author.class);
        authorService.save(author);
    }

    @RequestMapping(value = "/authors/{id}", method = RequestMethod.PUT)
    public Author update(@Valid @RequestBody AuthorDto authorDto,
                         @PathVariable("id") long id) {
        Author author = conversionService.convert(authorDto, Author.class);
        return authorService.update(author, id);
    }

    @RequestMapping(value = "/authors/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") long id) {
        authorService.delete(id);
    }

}