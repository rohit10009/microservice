package com.rohit.exceptions;

import com.rohit.model.ResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseExceptionHander extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductServiceCustomException.class)
    public ResponseEntity<ResponseError> handleProductServiceException(ProductServiceCustomException exception){
        new ResponseError();
        return new ResponseEntity<>(ResponseError.builder()
                .errorMeassge(exception.getMessage())
                .errorCode(exception.getErrorCode())
                .build(), HttpStatus.NOT_FOUND);
    }
}
