package com.softserve.books_repository_api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Илья on 29.09.2016.
 *
 */
public class ErrorMessageDto {

    @JsonProperty("error")
    private String errorMessage;

    public ErrorMessageDto() {
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}