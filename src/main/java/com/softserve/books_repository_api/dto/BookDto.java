package com.softserve.books_repository_api.dto;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * Created by ikar on 29.09.2016.
 *
 */
public class BookDto extends BaseBookDto {

    private String description;

    @NotNull
    @Range(min = 1000, max = 9999)
    private short year;

    public BookDto() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

}