package com.bridgeLabz.EmployeePayrollApp.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,Object>> handleValidationException(MethodArgumentNotValidException ex){
        Map<String,String> errors=new HashMap<>();

        for (FieldError error:ex.getBindingResult().getFieldErrors()){
            errors.put(error.getField(),error.getDefaultMessage());
        }

        Map<String,Object> response=new HashMap<>();
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("message","Validation failed for one or more fields.");
        response.put("errors",errors);

        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
}
