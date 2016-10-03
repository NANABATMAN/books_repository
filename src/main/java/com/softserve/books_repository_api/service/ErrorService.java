package com.softserve.books_repository_api.service;

import com.softserve.books_repository_api.dto.ErrorMessageDto;

/**
 * Created by ikar on 30.09.2016.
 *
 */
public interface ErrorService {

    ErrorMessageDto getErrorMessageDtoFromException(Exception ex);

}