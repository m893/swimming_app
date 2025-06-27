package com.project.Swimming_coach.model.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public class UserLoginRequestDto {

    @NotBlank(message = "Email is required")
    private String username;

    @NotBlank(message = "Password is required")
    private String password;

    public UserLoginRequestDto() {
    }

    public UserLoginRequestDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public @NotBlank(message = "Email is required") String getUsername() {
        return username;
    }

    public void setUsername(@NotBlank(message = "Email is required") String username) {
        this.username = username;
    }

    public @NotBlank(message = "Password is required") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Password is required") String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserLoginRequestDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
