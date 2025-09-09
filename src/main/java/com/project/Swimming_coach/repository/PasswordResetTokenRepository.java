package com.project.Swimming_coach.repository;

import com.project.Swimming_coach.model.entity.PasswordResetToken;
import com.project.Swimming_coach.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken,Long> {
    Optional<PasswordResetToken>findByToken(String token);
    void deleteByToken(String token);
    void deleteByUser(User user);
}
