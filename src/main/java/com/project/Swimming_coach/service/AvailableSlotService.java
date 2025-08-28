package com.project.Swimming_coach.service;

import com.project.Swimming_coach.model.entity.AvailableSlot;
import  com.project.Swimming_coach.dto.AvailableSlotDTO;
import com.project.Swimming_coach.dto.SlotRequestDTO;

import java.util.List;
import java.util.Optional;

public interface AvailableSlotService {
     AvailableSlotDTO addNewSlot (SlotRequestDTO availableSlot);
    AvailableSlot updateSlot(Long slotId , AvailableSlot availableSlot);
    void deleteSlot(Long slotId);
    Optional<AvailableSlot> getSlotById(Long slotId);
    List<AvailableSlot> getAllSlots();
    List<AvailableSlot> getSlotsByLocation(Long locationId);

}
