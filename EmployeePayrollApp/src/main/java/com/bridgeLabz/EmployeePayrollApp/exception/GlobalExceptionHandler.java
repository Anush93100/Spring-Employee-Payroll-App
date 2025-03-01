package com.bridgeLabz.EmployeePayrollApp.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
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

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.NOT_FOUND.value());
        response.put("message", ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String,String>> handleHttpMessageNotReadableException(
            HttpMessageNotReadableException exception){
        log.error("Invalid Date format ", exception);
        Map<String,String> response=new HashMap<>();
        String message="Exception while processing REST Request";
        String messageResponse="Should have Date in the  format dd MM yyyy";
        response.put(message,messageResponse);
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

}
