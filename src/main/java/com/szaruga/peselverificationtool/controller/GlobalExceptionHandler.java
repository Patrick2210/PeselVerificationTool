package com.szaruga.peselverificationtool.controller;

import com.szaruga.peselverificationtool.exception.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
/**
 * Global exception handler for handling exceptions across all controllers.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * Handles ValidationException and returns a ResponseEntity with status 400 Bad Request.
     *
     * @param ex The ValidationException that occurred.
     * @return ResponseEntity with status 400 Bad Request and the exception message.
     */
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Object> handleValidationException(ValidationException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }
    /**
     * Handles IllegalArgumentException and returns a ResponseEntity with status 400 Bad Request.
     *
     * @param ex The IllegalArgumentException that occurred.
     * @return ResponseEntity with status 400 Bad Request and the exception message.
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }
}