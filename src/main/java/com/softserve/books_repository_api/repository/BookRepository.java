package com.softserve.books_repository_api.repository;

import com.softserve.books_repository_api.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by ikar on 28.09.2016.
 *
 */
@Transactional
public interface BookRepository extends CrudRepository <Book, Long> {

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    Book save(Book book);

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    void delete(Long id);

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    boolean exists(Long id);

    List<Book> findByAuthor(String author);

}