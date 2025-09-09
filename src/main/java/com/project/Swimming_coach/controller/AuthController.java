package com.project.Swimming_coach.controller;

import com.project.Swimming_coach.model.dto.*;
import com.project.Swimming_coach.security.JwtService;
import com.project.Swimming_coach.service.PasswordResetService;
import com.project.Swimming_coach.service.RefreshTokenService;
import com.project.Swimming_coach.service.UserService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@Tag(name = "1. User Controller", description = "Operations related to users")
public class AuthController {
    private final UserService userService ;
    private final RefreshTokenService refreshTokenService;
    private final JwtService jwtService ;
    private final PasswordResetService passwordResetService;

    public AuthController(UserService userService, RefreshTokenService refreshTokenService, JwtService jwtService, PasswordResetService passwordResetService) {
        this.userService = userService;
        this.refreshTokenService = refreshTokenService;
        this.jwtService = jwtService;
        this.passwordResetService = passwordResetService;
    }
    @Operation(summary = "1. Parents registration")
    @PostMapping(value = "/register", produces = "application/json")
    public ResponseEntity<AuthResponseDto> register(@Valid @RequestBody UserRegisterRequestDto userRegisterRequestDto)
    {
        AuthResponseDto authResponseDto= userService.register(userRegisterRequestDto);
        return ResponseEntity.ok(authResponseDto);
    }

    @Operation(summary = "2. Login functionality")
    @PostMapping(value = "/login", produces = "application/json")
    public ResponseEntity<AuthResponseDto> login(@RequestBody UserLoginRequestDto userLoginRequestDto)
    {
        AuthResponseDto authResponseDto = userService.login(userLoginRequestDto);
        return ResponseEntity.ok(authResponseDto);
    }

    @Hidden
    @PostMapping(value = "/registerCoach", produces = "application/json")
    public ResponseEntity<AuthResponseDto> coachRegister(@Valid @RequestBody UserRegisterRequestDto userRegisterRequestDto)
    {
        AuthResponseDto authResponseDto= userService.coachRegister(userRegisterRequestDto);
        return ResponseEntity.ok(authResponseDto);
    }

    @Hidden
    @PostMapping(value = "/registerAdmin", produces = "application/json")
    public ResponseEntity<AuthResponseDto> adminRegister(@Valid @RequestBody UserRegisterRequestDto userRegisterRequestDto)
    {
        AuthResponseDto authResponseDto= userService.adminRegister(userRegisterRequestDto);
        return ResponseEntity.ok(authResponseDto);
    }

    @Operation(summary = "3. Refresh token")
    @PostMapping(value = "/refreshToken", produces = "application/json")
    public ResponseEntity<?> refreshToken(@RequestBody RefreshTokenRequestDto refreshTokenRequestDTO) {
        String requestRefreshToken = refreshTokenRequestDTO.getRefreshToken();

        return refreshTokenService.findByToken(requestRefreshToken)
                .map(token -> {
                    if (refreshTokenService.isRefreshTokenExpired(token)) {

                        refreshTokenService.deleteByUser(token.getUsers());
                        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Refresh token expired, please log in again");
                    }
                    String newAccessToken = jwtService.generateToken(
                            token.getUsers().getUsername(),
                            token.getUsers().getRole().name(),
                            token.getUsers().getStatus().name()
                    );
                    String newRefreshToken = jwtService.generateRefreshToken(token.getUsers().getUsername());
                    refreshTokenService.updateRefreshToken(token.getUsers().getUsername(), newRefreshToken);
                    return ResponseEntity.ok(new RefreshTokenDto(newAccessToken, newRefreshToken));
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid refresh token"));
    }
    @PostMapping(value = "forget-password", produces = "application/json")
    public ResponseEntity<ForgotAndResetPasswordResponseDto> forgetPassword(@Valid @RequestBody ForgotPasswordRequestDto reqeustDTO)
    {

        passwordResetService.generateResetToken(reqeustDTO);
        return ResponseEntity.ok(new ForgotAndResetPasswordResponseDto("Link sent Successfully"));
    }
    @PostMapping(value = "reset-password", produces = "application/json")
    public ResponseEntity<ForgotAndResetPasswordResponseDto> resetPassword(@RequestParam String token, @Valid @RequestBody ResetPasswordRequestDto resetPasswordRequestDto)
    {
        resetPasswordRequestDto.setToken(token);
        passwordResetService.resetPassword(resetPasswordRequestDto);
        return ResponseEntity.ok(new ForgotAndResetPasswordResponseDto("Password Reset Successfully"));
    }
}
