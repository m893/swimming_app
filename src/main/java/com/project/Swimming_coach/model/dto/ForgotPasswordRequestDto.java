package com.project.Swimming_coach.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ForgotPasswordRequestDto {
    @NotBlank
    @NotNull
    @Email
    private String email;

    public ForgotPasswordRequestDto(String email) {
        this.email = email;
    }

    public @NotBlank @NotNull @Email String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank @NotNull @Email String email) {
        this.email = email;
    }
}
