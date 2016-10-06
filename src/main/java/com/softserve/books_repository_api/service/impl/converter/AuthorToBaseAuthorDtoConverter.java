package com.softserve.books_repository_api.service.impl.converter;

import com.softserve.books_repository_api.dto.BaseAuthorDto;
import com.softserve.books_repository_api.entity.Author;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

/**
 * Created by ikar on 05.10.2016.
 *
 */
@Service
public class AuthorToBaseAuthorDtoConverter implements Converter<Author, BaseAuthorDto> {

    @Override
    public BaseAuthorDto convert(Author author) {
        BaseAuthorDto baseAuthorDto = new BaseAuthorDto();
        baseAuthorDto.setId(author.getId());
        baseAuthorDto.setName(author.getName());
        baseAuthorDto.setYear(author.getYear());
        return baseAuthorDto;
    }

}