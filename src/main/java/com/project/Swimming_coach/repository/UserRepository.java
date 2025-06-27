package com.project.Swimming_coach.repository;

import com.project.Swimming_coach.model.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {

    Optional<Users> findByEmail(String email);
    Optional<Users> findByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
}
