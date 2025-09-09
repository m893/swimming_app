package com.project.Swimming_coach.service.impl;

import com.project.Swimming_coach.exception.ResourceNotFoundException;
import com.project.Swimming_coach.model.dto.ForgotPasswordRequestDto;
import com.project.Swimming_coach.model.dto.ResetPasswordRequestDto;
import com.project.Swimming_coach.model.entity.PasswordResetToken;
import com.project.Swimming_coach.model.entity.User;
import com.project.Swimming_coach.repository.PasswordResetTokenRepository;
import com.project.Swimming_coach.repository.UserRepository;
import com.project.Swimming_coach.service.EmailService;
import com.project.Swimming_coach.service.PasswordResetService;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Transactional
public class PasswordResetServiceImpl implements PasswordResetService {
    final private UserRepository userRepository ;
    final private PasswordResetTokenRepository passwordResetTokenRepository;
    final private EmailService emailService;
    final private PasswordEncoder passwordEncoder;

    public PasswordResetServiceImpl(UserRepository userRepository, PasswordResetTokenRepository passwordResetTokenRepository, EmailService emailService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordResetTokenRepository = passwordResetTokenRepository;
        this.emailService = emailService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void generateResetToken(ForgotPasswordRequestDto forgotPasswordRequestDto) {
        User user = userRepository.findByEmail(forgotPasswordRequestDto.getEmail()).
                orElseThrow(() -> new ResourceNotFoundException("No user with this email"));

        passwordResetTokenRepository.deleteByUser(user);
        String token = UUID.randomUUID().toString();
        PasswordResetToken passwordResetToken = new PasswordResetToken();
        passwordResetToken.setToken(token);
        passwordResetToken.setUser(user);
        passwordResetToken.setExpiryDate(LocalDateTime.now().plusMinutes(15));
        passwordResetTokenRepository.save(passwordResetToken);
        String url ="http://localhost:8080/auth/reset-password?token=" + token;
        emailService.sendForgetPasswordToken(user.getEmail(),url);
    }

    @Override
    public void resetPassword(ResetPasswordRequestDto resetPasswordRequestDto) {
        PasswordResetToken passwordResetToken = passwordResetTokenRepository.findByToken(resetPasswordRequestDto.getToken()).
                orElseThrow(()->new ResourceNotFoundException("Token Not Found"));
        if (passwordResetToken.isExpired())
        {
            throw new ResourceNotFoundException("Token Expired");
        }
        User user = passwordResetToken.getUser();
        user.setPassword(passwordEncoder.encode(resetPasswordRequestDto.getNewPassword()));
        userRepository.save(user);
        passwordResetTokenRepository.deleteByToken(resetPasswordRequestDto.getToken());
    }
    }

