package com.blog.blog_apis.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.blog.blog_apis.payloads.ApiResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleException(Exception ex, WebRequest request) {
        // Log the exception (you can use a logging framework like SLF4J)
        ex.printStackTrace();
        System.out.println(ex.getMessage());

        // Return a custom error message and HTTP status code
        return new ResponseEntity<ApiResponse<String>>(new ApiResponse<>(ex.getMessage(), false), HttpStatus.NOT_FOUND);
    }
}
