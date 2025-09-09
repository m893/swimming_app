package com.project.Swimming_coach.exception;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.ConstraintViolationException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
@Hidden
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorDto> handleValidationException(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());


        String message = "Validation failed. Error count: " + errors.size();
        ValidationErrorDto response = new ValidationErrorDto(
                HttpStatus.BAD_REQUEST.value(),
                message,
                errors,
                LocalDateTime.now()
        );
        System.out.println("first method");

        return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body(response);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ValidationErrorDto> handleConstraintViolationException(ConstraintViolationException ex) {
        List<String> errors = ex.getConstraintViolations()
                .stream()
                .map(v -> v.getPropertyPath() + ": " + v.getMessage())
                .collect(Collectors.toList());

        String message = "Validation failed. Error count: " + errors.size();
        ValidationErrorDto response = new ValidationErrorDto(
                HttpStatus.BAD_REQUEST.value(),
                message,
                errors,
                LocalDateTime.now()
        );
        System.out.println("second method");
        return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body(response);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ValidationErrorDto> handleResourceNotFound(ResourceNotFoundException ex) {
        ValidationErrorDto response = new ValidationErrorDto(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                List.of(ex.getMessage()), // reuse as error list
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
    // You can handle other exceptions like custom AppException, etc. here too
}

