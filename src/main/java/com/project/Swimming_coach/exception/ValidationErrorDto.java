package com.project.Swimming_coach.exception;

import java.time.LocalDateTime;
import java.util.List;

public class ValidationErrorDto {
    private final int status;
    private final String message;
    private final List<String> errors;
    private final LocalDateTime timestamp;

    public ValidationErrorDto(int status, String message, List<String> errors, LocalDateTime timestamp) {
        this.status = status;
        this.message = message;
        this.errors = errors;
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getErrors() {
        return errors;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

// Getters and Setters
}
