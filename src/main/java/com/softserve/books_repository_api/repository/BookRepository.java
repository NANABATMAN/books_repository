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

    List<Book> findByAuthor(String author);

}