package com.project.Swimming_coach.repository;

import com.project.Swimming_coach.model.entity.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoachRepository extends JpaRepository<Coach , Long> {
    List<Coach> findByNameContainingIgnoreCase(String name);
}
