package com.project.Swimming_coach.repository;

import com.project.Swimming_coach.model.entity.Trainees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraineesRepository extends JpaRepository<Trainees,Integer> {
}
