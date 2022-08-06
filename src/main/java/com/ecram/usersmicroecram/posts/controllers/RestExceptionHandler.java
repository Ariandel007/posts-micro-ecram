package com.ecram.usersmicroecram.posts.controllers;

import com.ecram.usersmicroecram.posts.exceptions.ErrorConvertMultiPart;
import com.ecram.usersmicroecram.posts.exceptions.GeneralBodyExceptionHandler;
import com.ecram.usersmicroecram.posts.exceptions.GeneralException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value= { ErrorConvertMultiPart.class })
    protected ResponseEntity<Object> internalServerErrpr(GeneralException ex, WebRequest request) {
        return handleExceptionInternal(
                ex,
                new GeneralBodyExceptionHandler(ex.getErrorCode(),ex.getMessage(),ex.getLocalizedMessage()),
                new HttpHeaders(),
                HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

}