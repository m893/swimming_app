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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/auth")
@Tag(name = "Authentication", description = "Endpoints for user registration and login")
public class AuthController {
    private final UserService userService ;

    public AuthController(UserService userService) {
        this.userService = userService;
    }
    @Operation(
            summary = "Register a new user",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully registered",
                            content = @Content(schema = @Schema(implementation = AuthResponseDto.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid input")
            }
    )
    @PostMapping("/register")
    public ResponseEntity<AuthResponseDto> register(@RequestBody UserRegisterRequestDto userRegisterRequestDto)
    {
        AuthResponseDto authResponseDto= userService.register(userRegisterRequestDto);
        return ResponseEntity.ok(authResponseDto);
    }
    @Operation(
            summary = "Login with username and password",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Login successful",
                            content = @Content(schema = @Schema(implementation = AuthResponseDto.class))),
                    @ApiResponse(responseCode = "401", description = "Invalid credentials")
            }
    )
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody UserLoginRequestDto userLoginRequestDto)
    {
        AuthResponseDto authResponseDto = userService.login(userLoginRequestDto);
        return ResponseEntity.ok(authResponseDto);
    }
}
