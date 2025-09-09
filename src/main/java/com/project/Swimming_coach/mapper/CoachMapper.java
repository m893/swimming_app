// CoachMapper.java
package com.project.Swimming_coach.mapper;

import com.project.Swimming_coach.model.dto.CoachDto;
import com.project.Swimming_coach.model.dto.CoachRequestDto;
import com.project.Swimming_coach.model.entity.Coach;

public class CoachMapper {

    // Entity -> DTO
    public static CoachDto toDTO(Coach coach) {
        if (coach == null) return null;

        CoachDto dto = new CoachDto();
        dto.setId(coach.getCoachId());
        dto.setName(coach.getName());
        dto.setSpecialization(coach.getSpecialization());
        if (coach.getAvailableSlots() != null) {
            dto.setAvailableSlots(
                    coach.getAvailableSlots().stream().
                            map(slot -> AvailableSlotMapper.mapSlotToDTO(slot)).
                            toList()
            );
        }

        return dto;
    }

    // RequestDTO -> Entity
    public static Coach toEntity(CoachRequestDto request) {
        if (request == null) return null;

        Coach coach = new Coach();
        coach.setName(request.getName());
        coach.setSpecialization(request.getSpecialization());
        return coach;
    }
}
