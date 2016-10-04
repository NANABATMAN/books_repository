package com.softserve.books_repository_api.utils;

import com.softserve.books_repository_api.dto.ErrorMessageDto;
import org.springframework.stereotype.Component;

/**
 * Created by ikar on 04.10.2016.
 *
 */
@Component
public class ExceptionUtils {

    public ErrorMessageDto getErrorMessageDtoFromException(Exception ex) {
        ErrorMessageDto errorMessageDto = new ErrorMessageDto();
        errorMessageDto.setErrorMessage(ex.getMessage());
        return errorMessageDto;
    }

}