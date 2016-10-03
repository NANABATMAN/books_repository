package com.softserve.books_repository_api.service.impl.converter;

import com.softserve.books_repository_api.dto.BaseBookDto;
import com.softserve.books_repository_api.entity.Book;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

/**
 * Created by ikar on 29.09.2016.
 *
 */
@Service
public class BookToBaseBookDtoConverter implements Converter<Book, BaseBookDto> {

    @Override
    public BaseBookDto convert(Book book) {
        BaseBookDto baseBookDto = new BaseBookDto();
        baseBookDto.setAuthor(book.getAuthor());
        baseBookDto.setTitle(book.getTitle());
        return baseBookDto;
    }

}