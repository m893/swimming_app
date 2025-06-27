package com.project.Swimming_coach.exception;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Data
public class ValidationErrorResponse {
    private int status;
    private String message;
    private List<String> errors;
    private LocalDateTime timestamp;

    public ValidationErrorResponse(int status, String message, List<String> errors, LocalDateTime timestamp) {
        this.status = status;
        this.message = message;
        this.errors = errors;
        this.timestamp = timestamp;
    }

    // Getters and Setters
}
