package com.softserve.books_repository_api.service.impl.converter;

import com.softserve.books_repository_api.dto.AuthorDto;
import com.softserve.books_repository_api.entity.Author;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

/**
 * Created by ikar on 06.10.2016.
 *
 */
@Service
public class AuthorToAuthorDtoConverter implements Converter<Author, AuthorDto> {

    @Override
    public AuthorDto convert(Author author) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId());
        authorDto.setYear(author.getYear());
        authorDto.setName(author.getName());
        authorDto.setBooks(author.getBooks());
        return authorDto;
    }

}