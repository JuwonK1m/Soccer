package com.kimjuwon.soccer.controller;

import com.kimjuwon.soccer.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity NotFoundException(NotFoundException e) {
        return new ResponseEntity<Map<String, Object>>(e.getMap(), HttpStatus.NOT_FOUND);
    }
}
