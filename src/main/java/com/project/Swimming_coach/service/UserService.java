package com.project.Swimming_coach.service;

import com.project.Swimming_coach.model.dto.AuthResponseDto;
import com.project.Swimming_coach.model.dto.UserLoginRequestDto;
import com.project.Swimming_coach.model.dto.UserRegisterRequestDto;

import java.util.List;

public interface UserService {
    AuthResponseDto register(UserRegisterRequestDto uSerRequestDto);
    AuthResponseDto coachRegister(UserRegisterRequestDto uSerRequestDto);
    AuthResponseDto adminRegister(UserRegisterRequestDto uSerRequestDto);
    AuthResponseDto login(UserLoginRequestDto userLoginRequestDto);
    List<AuthResponseDto>getAllAccounts();
}
