package com.bzetab.finanzaspersonales.utils.exceptions.handler;

import com.bzetab.finanzaspersonales.utils.exceptions.custom.ResourceNotFoundException;
import com.bzetab.finanzaspersonales.utils.exceptions.model.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException exception,
                                                                   HttpServletRequest request) {
        List<String> errors  = exception
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .toList();

        return ResponseEntity.badRequest().body(ErrorResponse.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .error("Validation failed")
                        .details(errors)
                        .path(request.getRequestURI())
                        .build());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException exception,
                                                                            HttpServletRequest request){
        List<String> error = exception.getConstraintViolations().stream()
                .map(violation -> {
                    String fieldPath = violation.getPropertyPath().toString();
                    String field = fieldPath.contains(".")
                            ? fieldPath.substring(fieldPath.lastIndexOf('.') + 1)
                            : fieldPath;
                    String message = violation.getMessage();
                    return field + ": " + message;
                })
                .toList();

        return ResponseEntity.badRequest().body(ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Validation failed")
                .details(error)
                .path(request.getRequestURI())
                .build());
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> resourceNotFoundException(ResourceNotFoundException resourceNotFoundException,
                                                                   HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErrorResponse.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.NOT_FOUND.value())
                        .error(resourceNotFoundException.getMessage())
                        .path(request.getRequestURI())
                        .build());
    }
}
