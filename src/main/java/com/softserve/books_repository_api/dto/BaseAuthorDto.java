package com.softserve.books_repository_api.dto;

import com.sun.istack.internal.NotNull;
import org.hibernate.validator.constraints.Range;

/**
 * Created by Илья on 04.10.2016.
 *
 */
public class BaseAuthorDto {

    private long id;

    @NotNull
    private String name;

    @NotNull
    @Range(min = 1000, max = 9999)
    private short year;

    public BaseAuthorDto() {
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