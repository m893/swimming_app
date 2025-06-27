package com.project.Swimming_coach.service;

import com.project.Swimming_coach.model.dto.AuthResponseDto;
import com.project.Swimming_coach.model.dto.UserLoginRequestDto;
import com.project.Swimming_coach.model.dto.UserRegisterRequestDto;

public interface UserService {
    AuthResponseDto register(UserRegisterRequestDto uSerRequestDto);
    AuthResponseDto login(UserLoginRequestDto userLoginRequestDto);
}
