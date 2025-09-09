package com.project.Swimming_coach.model.dto;

import jakarta.validation.constraints.NotNull;

public class ResetPasswordRequestDto {
    @NotNull
    private String token ;
    @NotNull
    private String newPassword;

    public ResetPasswordRequestDto(String token, String newPassword) {
        this.token = token;
        this.newPassword = newPassword;
    }

    public @NotNull String getToken() {
        return token;
    }

    public void setToken(@NotNull String token) {
        this.token = token;
    }

    public @NotNull String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(@NotNull String newPassword) {
        this.newPassword = newPassword;
    }
}
