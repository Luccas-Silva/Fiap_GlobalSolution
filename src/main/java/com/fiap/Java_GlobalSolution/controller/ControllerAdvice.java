package com.fiap.Java_GlobalSolution.controller;

import org.hibernate.PropertyValueException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler
    public ResponseEntity HandlePropertyValueException(PropertyValueException exception) {
        return ResponseEntity.badRequest().build();
    }

}
