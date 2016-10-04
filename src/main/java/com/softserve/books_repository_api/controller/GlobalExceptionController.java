package com.softserve.books_repository_api.controller;

import com.softserve.books_repository_api.dto.ErrorMessageDto;
import com.softserve.books_repository_api.utils.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Илья on 29.09.2016.
 *
 */
@ControllerAdvice
@RestController
public class GlobalExceptionController {

    @Autowired
    ExceptionUtils exceptionUtils;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ErrorMessageDto handleValidationException(MethodArgumentNotValidException ex) {
        return exceptionUtils.getErrorMessageDtoFromException(ex);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = Exception.class)
    public ErrorMessageDto handleException(Exception ex) {
        return exceptionUtils.getErrorMessageDtoFromException(ex);
    }

}