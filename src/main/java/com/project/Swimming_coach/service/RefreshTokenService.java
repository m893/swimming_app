package com.project.Swimming_coach.service;

import com.project.Swimming_coach.model.entity.RefreshToken;
import com.project.Swimming_coach.model.entity.Users;

import java.util.Optional;

public interface RefreshTokenService {
    public RefreshToken createRefreshToken(String userName , String token);
    public RefreshToken updateRefreshToken(String userName , String token);
    public Optional<RefreshToken> findByToken(String token);
    public boolean isRefreshTokenExpired(RefreshToken token);
    public void deleteByUser(Users users);
}
