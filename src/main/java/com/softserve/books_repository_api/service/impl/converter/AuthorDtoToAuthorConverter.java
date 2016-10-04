package com.softserve.books_repository_api.service.impl.converter;

import com.softserve.books_repository_api.dto.AuthorDto;
import com.softserve.books_repository_api.entity.Author;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

/**
 * Created by Илья on 04.10.2016.
 *
 */
@Service
public class AuthorDtoToAuthorConverter implements Converter<AuthorDto, Author> {

    @Override
    public Author convert(AuthorDto authorDto) {
        Author author = new Author();
        author.setName(authorDto.getName());
        author.setYear(authorDto.getYear());
        return author;
    }

}