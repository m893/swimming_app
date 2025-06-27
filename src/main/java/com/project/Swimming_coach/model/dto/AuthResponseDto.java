package com.project.Swimming_coach.model.dto;


import java.time.LocalDate;
public class AuthResponseDto {
    public AuthResponseDto() {
    }

    public AuthResponseDto(Integer id, String username, String email, String fullName,
                           String phoneNumber, String role, String status,
                           LocalDate createdAt, String token) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.status = status;
        this.createdAt = createdAt;
        this.token = token;
    }

    private Integer id;
    private String username;
    private String email;
    private String fullName;
    private String phoneNumber;
    private String role;    // Enum as String
    private String status;  // Enum as String
    private LocalDate createdAt;
    private String token;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "AuthResponseDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", role='" + role + '\'' +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                ", token='" + token + '\'' +
                '}';
    }
}
