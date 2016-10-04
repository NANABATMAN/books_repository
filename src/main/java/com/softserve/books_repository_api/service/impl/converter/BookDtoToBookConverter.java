package com.softserve.books_repository_api.service.impl.converter;

import com.softserve.books_repository_api.dto.BookDto;
import com.softserve.books_repository_api.entity.Book;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

/**
 * Created by ikar on 29.09.2016.
 *
 */
@Service
public class BookDtoToBookConverter implements Converter<BookDto, Book> {

    @Override
    public Book convert(BookDto bookDto) {
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setYear(bookDto.getYear());
        book.setDescription(bookDto.getDescription());
        return book;
    }

}