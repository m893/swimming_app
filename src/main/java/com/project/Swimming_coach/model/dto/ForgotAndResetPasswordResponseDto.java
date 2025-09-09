package com.project.Swimming_coach.model.dto;

public class ForgotAndResetPasswordResponseDto {
    private  String message ;

    public ForgotAndResetPasswordResponseDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
