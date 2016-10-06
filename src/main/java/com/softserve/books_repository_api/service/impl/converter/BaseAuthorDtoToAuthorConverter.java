package com.softserve.books_repository_api.service.impl.converter;

import com.softserve.books_repository_api.dto.BaseAuthorDto;
import com.softserve.books_repository_api.entity.Author;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

/**
 * Created by ikar on 06.10.2016
 */
@Service
public class BaseAuthorDtoToAuthorConverter implements Converter<BaseAuthorDto, Author> {

    @Override
    public Author convert(BaseAuthorDto baseAuthorDto) {
        Author author = new Author();
        author.setId(baseAuthorDto.getId());
        author.setYear(baseAuthorDto.getYear());
        author.setName(baseAuthorDto.getName());
        return author;
    }

}