package com.project.Swimming_coach.repository;

import com.project.Swimming_coach.model.entity.AvailableSlot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvailableSlotRepository extends JpaRepository<AvailableSlot , Long> {
    List<AvailableSlot> findByLocation_LocationId(Long locationId);

}
