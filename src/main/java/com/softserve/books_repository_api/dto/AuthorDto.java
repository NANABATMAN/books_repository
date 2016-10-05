package com.softserve.books_repository_api.dto;

import com.softserve.books_repository_api.entity.Book;
import com.sun.istack.internal.NotNull;
import org.hibernate.validator.constraints.Range;

import java.util.Set;

/**
 * Created by Илья on 04.10.2016.
 *
 */
public class AuthorDto {

    private long id;

    @NotNull
    private String name;

    @NotNull
    @Range(min = 1000, max = 9999)
    private short year;

    public AuthorDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

}