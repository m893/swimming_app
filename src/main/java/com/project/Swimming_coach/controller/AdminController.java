package com.project.Swimming_coach.controller;

import com.project.Swimming_coach.model.dto.AuthResponseDto;
import com.project.Swimming_coach.model.dto.UserRegisterRequestDto;
import com.project.Swimming_coach.model.entity.AvailableSlot;
import com.project.Swimming_coach.model.entity.Locations;
import com.project.Swimming_coach.service.LocationSerivce;
import com.project.Swimming_coach.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/v1/")
public class AdminController {
    private final UserService userService ;
    private final LocationSerivce locationSerivce;

    public AdminController(UserService userService, LocationSerivce locationSerivce) {
        this.userService = userService;
        this.locationSerivce = locationSerivce;
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<AuthResponseDto>> getAllAccounts()
    {
        List<AuthResponseDto> list = userService.getAllAccounts();
        return ResponseEntity.ok(list);
    }



}
