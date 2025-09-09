package com.project.Swimming_coach.service;

import com.project.Swimming_coach.model.entity.AvailableSlot;
import  com.project.Swimming_coach.model.dto.*;


import java.util.List;

public interface AvailableSlotService {
     AvailableSlotDto addNewSlot (SlotRequestDto availableSlot);
    AvailableSlot updateSlot(Long slotId , AvailableSlot availableSlot);
    void deleteSlot(Long slotId);
    AvailableSlotDto getSlotById(Long slotId);
    List<AvailableSlot> getAllSlots();
    List<AvailableSlot> getSlotsByLocation(Long locationId);

}
