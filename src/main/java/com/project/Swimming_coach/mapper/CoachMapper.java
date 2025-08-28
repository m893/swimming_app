// CoachMapper.java
package com.project.Swimming_coach.mapper;

import com.project.Swimming_coach.model.dto.CoachDTO;
import com.project.Swimming_coach.model.dto.CoachRequestDTO;
import com.project.Swimming_coach.model.entity.Coach;

import java.util.Optional;
import java.util.stream.Collectors;

public class CoachMapper {

    // Entity -> DTO
    public static CoachDTO toDTO(Coach coach) {
        if (coach == null) return null;

        CoachDTO dto = new CoachDTO();
        dto.setId(coach.getCoachId());
        dto.setName(coach.getName());
        dto.setSpecialization(coach.getSpecialization());

        if (coach.getAvailableSlots() != null) {
            dto.setAvailableSlots(
                    coach.getAvailableSlots().stream()
                            .map(slot -> slot.getSlotId()) // or map to AvailableSlotDTO
                            .collect(Collectors.toList()).reversed()
            );
        }

        return dto;
    }

    // RequestDTO -> Entity
    public static Coach toEntity(CoachRequestDTO request) {
        if (request == null) return null;

        Coach coach = new Coach();
        coach.setName(request.getName());
        coach.setSpecialization(request.getSpecialization());
        return coach;
    }
}
