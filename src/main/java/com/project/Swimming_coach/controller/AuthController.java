package com.project.Swimming_coach.controller;

import com.project.Swimming_coach.model.dto.AuthResponseDto;
import com.project.Swimming_coach.model.dto.UserLoginRequestDto;
import com.project.Swimming_coach.model.dto.UserRegisterRequestDto;
import com.project.Swimming_coach.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final UserService userService ;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/register", produces = "application/json")
    public ResponseEntity<AuthResponseDto> register(@Valid @RequestBody UserRegisterRequestDto userRegisterRequestDto)
    {
        AuthResponseDto authResponseDto= userService.register(userRegisterRequestDto);
        return ResponseEntity.ok(authResponseDto);
    }

    @PostMapping(value = "/login", produces = "application/json")
    public ResponseEntity<AuthResponseDto> login(@RequestBody UserLoginRequestDto userLoginRequestDto)
    {
        AuthResponseDto authResponseDto = userService.login(userLoginRequestDto);
        return ResponseEntity.ok(authResponseDto);
    }
    @PostMapping(value = "/registerCoach", produces = "application/json")
    public ResponseEntity<AuthResponseDto> coachRegister(@Valid @RequestBody UserRegisterRequestDto userRegisterRequestDto)
    {
        AuthResponseDto authResponseDto= userService.coachRegister(userRegisterRequestDto);
        return ResponseEntity.ok(authResponseDto);
    }
    @PostMapping(value = "/registerAdmin", produces = "application/json")
    public ResponseEntity<AuthResponseDto> adminRegister(@Valid @RequestBody UserRegisterRequestDto userRegisterRequestDto)
    {
        AuthResponseDto authResponseDto= userService.adminRegister(userRegisterRequestDto);
        return ResponseEntity.ok(authResponseDto);
    }
}
