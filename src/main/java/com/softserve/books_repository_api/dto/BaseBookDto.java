package com.softserve.books_repository_api.dto;

import javax.validation.constraints.NotNull;

/**
 * Created by ikar on 29.09.2016.
 *
 */
public class BaseBookDto {

    private long id;

    @NotNull
    private String title;

    public BaseBookDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}