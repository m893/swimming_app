package com.project.Swimming_coach.controller;

import com.project.Swimming_coach.model.dto.AuthResponseDto;
import com.project.Swimming_coach.service.LocationService;
import com.project.Swimming_coach.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/v1/")
public class AdminController {
    private final UserService userService ;
    private final LocationService locationService;

    public AdminController(UserService userService, LocationService locationService) {
        this.userService = userService;
        this.locationService = locationService;
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<AuthResponseDto>> getAllAccounts()
    {
        List<AuthResponseDto> list = userService.getAllAccounts();
        return ResponseEntity.ok(list);
    }



}
