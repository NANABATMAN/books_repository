package com.softserve.books_repository_api.controller;

import com.softserve.books_repository_api.dto.ErrorMessageDto;
import com.softserve.books_repository_api.service.ErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;

/**
 * Created by Илья on 29.09.2016.
 *
 */
@ControllerAdvice
@RestController
public class GlobalExceptionController {

    @Autowired
    ErrorService errorService;

    @ExceptionHandler(value = Exception.class)
    public ErrorMessageDto handleException(Exception ex) {
        return errorService.getErrorMessageDtoFromException(ex);
    }

}