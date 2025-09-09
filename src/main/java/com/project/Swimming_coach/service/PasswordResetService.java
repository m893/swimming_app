package com.project.Swimming_coach.service;

import com.project.Swimming_coach.model.dto.ForgotPasswordRequestDto;
import com.project.Swimming_coach.model.dto.ResetPasswordRequestDto;

public interface PasswordResetService {

    public void generateResetToken(ForgotPasswordRequestDto forgotPasswordRequestDto);
    public void resetPassword(ResetPasswordRequestDto resetPasswordRequestDto);


}
