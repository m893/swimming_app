package com.project.Swimming_coach.repository;

import com.project.Swimming_coach.model.entity.RefreshToken;
import com.project.Swimming_coach.model.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken,Long> {
    Optional<RefreshToken> findByToken(String token);
    Optional<RefreshToken> findByUser(Users user );
    void deleteByUser(Users user);

}
