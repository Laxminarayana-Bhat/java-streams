package com.learn.javastreams.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice//controller advice+response body
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomErrResponse> globalRootException(Exception x) {
        CustomErrResponse customErrResponse = new CustomErrResponse(HttpStatus.BAD_REQUEST.value(), x.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(customErrResponse, HttpStatus.BAD_REQUEST);
    }

}
