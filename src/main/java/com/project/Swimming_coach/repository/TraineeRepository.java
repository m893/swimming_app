package com.project.Swimming_coach.repository;

import com.project.Swimming_coach.model.entity.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraineeRepository extends JpaRepository<Trainee,Integer> {
}
