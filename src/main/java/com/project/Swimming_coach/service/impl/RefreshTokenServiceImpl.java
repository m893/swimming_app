package com.project.Swimming_coach.service.impl;

import com.project.Swimming_coach.exception.ResourceNotFoundException;
import com.project.Swimming_coach.model.entity.RefreshToken;
import com.project.Swimming_coach.model.entity.Users;
import com.project.Swimming_coach.repository.RefreshTokenRepository;
import com.project.Swimming_coach.repository.UserRepository;
import com.project.Swimming_coach.service.RefreshTokenService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class RefreshTokenServiceImpl implements RefreshTokenService {
    final private RefreshTokenRepository refreshTokenRepository ;
    final private UserRepository userRepository ;

    public RefreshTokenServiceImpl(RefreshTokenRepository refreshTokenRepository, UserRepository userRepository) {
        this.refreshTokenRepository = refreshTokenRepository;
        this.userRepository = userRepository;
    }

    @Override
    public RefreshToken createRefreshToken(String userName, String token) {
        Users user = userRepository.findByUsername(userName)
                .orElseThrow(() -> new ResourceNotFoundException("User Not Found"));

        // Check if this user already has a refresh token
        return refreshTokenRepository.findByUser(user)
                .map(existingToken -> {
                    // Update existing token
                    existingToken.setToken(token);
                    existingToken.setExpiryDate(
                            new Date(System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 7).toInstant()
                    );
                    return refreshTokenRepository.save(existingToken);
                })
                .orElseGet(() -> {
                    // Create new token if not exists
                    RefreshToken refreshToken = new RefreshToken();
                    refreshToken.setUsers(user);
                    refreshToken.setToken(token);
                    refreshToken.setExpiryDate(
                            new Date(System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 7).toInstant()
                    );
                    return refreshTokenRepository.save(refreshToken);
                });
    }

    @Override
    public RefreshToken updateRefreshToken(String userName, String token) {
        Users user = userRepository.findByUsername(userName).orElseThrow(()-> new ResourceNotFoundException("User Not Exist"));
        RefreshToken refreshToken = refreshTokenRepository.findByUser(user).orElseThrow(()-> new ResourceNotFoundException("Refresh Token Not Found For USer"));

        refreshToken.setToken(token);
        refreshToken.setExpiryDate(new Date(System.currentTimeMillis()+1000L*60*60*24*7).toInstant());
        return refreshTokenRepository.save(refreshToken);
    }

    @Override
    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }

    @Override
    public boolean isRefreshTokenExpired(RefreshToken token) {
        return token.getExpiryDate().isBefore(new Date().toInstant());
    }

    @Override
    public void deleteByUser(Users users) {
        refreshTokenRepository.deleteByUser(users);

    }
}
