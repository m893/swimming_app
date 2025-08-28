package com.project.Swimming_coach.mapper;

import com.project.Swimming_coach.model.dto.*;
import com.project.Swimming_coach.model.entity.AvailableSlot;

import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.util.Collections;
import java.util.stream.Collectors;

@Component
public class AvailableSlotMapper {
    public static AvailableSlotDTO mapSlotToDTO(AvailableSlot slot)
    {
        return new AvailableSlotDTO(
                slot.getSlotId(),
                slot.getDaysOfWeek().stream()
                        .map(DayOfWeek::name) // convert enum -> String
                        .collect(Collectors.toSet()),
                slot.getStartTime(),
                slot.getEndTime(),
                slot.getStartDate(),
                slot.getEndDate(),
                slot.getMaxCapacity(),
                slot.getCoach() != null ? slot.getCoach().getName() : null,
                slot.getLocation() != null ? slot.getLocation().getLocationName() : null,
                slot.getLevel() != null ? slot.getLevel().getName() : null
        );
    }
}
