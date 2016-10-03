package com.softserve.books_repository_api.dto;

import javax.validation.constraints.NotNull;

/**
 * Created by ikar on 29.09.2016.
 *
 */
public class BaseBookDto {

    @NotNull
    private String author;

    @NotNull
    private String title;

    public BaseBookDto() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}