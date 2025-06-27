package com.project.Swimming_coach.model.entity;

import com.project.Swimming_coach.model.enums.Role;
import com.project.Swimming_coach.model.enums.Status;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private String username ;
    private String email;
    private String password ;
    private String full_name;
    private String phone_number;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDate created_at;

    public Users() {
    }



    public Users(Integer id, String username, String email, String password, String full_name, String phone_number, Role role, Status status, LocalDate created_at) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.full_name = full_name;
        this.phone_number = phone_number;
        this.role = role;
        this.status = status;
        this.created_at = created_at;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", full_name='" + full_name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", role=" + role +
                ", status=" + status +
                ", created_at=" + created_at +
                '}';
    }
}
