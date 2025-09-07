package com.project.Swimming_coach.controller;

import com.project.Swimming_coach.model.dto.*;
import com.project.Swimming_coach.security.JwtService;
import com.project.Swimming_coach.service.RefreshTokenService;
import com.project.Swimming_coach.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final UserService userService ;
    private final RefreshTokenService refreshTokenService;
    private final JwtService jwtService ;

    public AuthController(UserService userService, RefreshTokenService refreshTokenService, JwtService jwtService) {
        this.userService = userService;
        this.refreshTokenService = refreshTokenService;
        this.jwtService = jwtService;
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

    @PostMapping(value = "/refreshToken", produces = "application/json")
    public ResponseEntity<?> refreshToken(@RequestBody RefreshTokenRequestDTO refreshTokenRequestDTO) {
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
                    return ResponseEntity.ok(new RefreshTokeDTO(newAccessToken, newRefreshToken));
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid refresh token"));
    }
}
