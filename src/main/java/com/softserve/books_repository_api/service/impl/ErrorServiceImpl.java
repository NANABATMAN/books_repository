package com.softserve.books_repository_api.service.impl;

import com.softserve.books_repository_api.dto.ErrorMessageDto;
import com.softserve.books_repository_api.service.ErrorService;
import org.springframework.stereotype.Service;

/**
 * Created by ikar on 30.09.2016.
 *
 */
@Service
public class ErrorServiceImpl implements ErrorService {

    public ErrorMessageDto getErrorMessageDtoFromException(Exception ex) {
        ErrorMessageDto errorMessageDto = new ErrorMessageDto();
        errorMessageDto.setErrorMessage(ex.getMessage());
        return errorMessageDto;
    }

}