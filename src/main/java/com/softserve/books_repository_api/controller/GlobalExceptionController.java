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

import javax.persistence.EntityNotFoundException;

/**
 * Created by Илья on 29.09.2016.
 *
 */
@ControllerAdvice
@RestController
public class GlobalExceptionController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ErrorMessageDto handleValidationException(MethodArgumentNotValidException ex) {
        return ExceptionUtils.getErrorMessageDtoFromException(ex);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = EntityNotFoundException.class)
    public ErrorMessageDto handleEntityNotFoundException(EntityNotFoundException ex) {
        return ExceptionUtils.getErrorMessageDtoFromException(ex);
    }

    @ExceptionHandler(value = Exception.class)
    public ErrorMessageDto handleException(Exception ex) {
        return ExceptionUtils.getErrorMessageDtoFromException(ex);
    }

}