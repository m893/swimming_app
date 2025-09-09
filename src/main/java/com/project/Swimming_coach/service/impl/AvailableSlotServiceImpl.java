package com.project.Swimming_coach.service.impl;

import com.project.Swimming_coach.exception.ResourceNotFoundException;
import com.project.Swimming_coach.mapper.AvailableSlotMapper;
import com.project.Swimming_coach.model.dto.SlotRequestDto;
import com.project.Swimming_coach.model.entity.AvailableSlot;
import com.project.Swimming_coach.model.entity.Coach;
import com.project.Swimming_coach.model.entity.Level;
import com.project.Swimming_coach.model.entity.Location;
import com.project.Swimming_coach.repository.AvailableSlotRepository;
import com.project.Swimming_coach.repository.CoachRepository;
import com.project.Swimming_coach.repository.LevelRepository;
import com.project.Swimming_coach.repository.LocationRepository;
import com.project.Swimming_coach.service.AvailableSlotService;
import org.springframework.stereotype.Service;
import  com.project.Swimming_coach.model.dto.*;


import java.time.DayOfWeek;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AvailableSlotServiceImpl implements AvailableSlotService {

     private final AvailableSlotRepository availableSlotRepository;
     private final AvailableSlotMapper availableSlotMapper ;
     private final CoachRepository coachRepository;
     private final LocationRepository locationRepository ;
     private final LevelRepository levelRepository;

    public AvailableSlotServiceImpl(AvailableSlotRepository availableSlotRepository, AvailableSlotMapper availableSlotMapper, CoachRepository coachRepository, LocationRepository locationRepository, LevelRepository levelRepository) {
        this.availableSlotRepository = availableSlotRepository;
        this.availableSlotMapper = availableSlotMapper;
        this.coachRepository = coachRepository;
        this.locationRepository = locationRepository;
        this.levelRepository = levelRepository;
    }

    @Override
    public AvailableSlotDto addNewSlot(SlotRequestDto request) {
        AvailableSlot slot = new AvailableSlot();

        slot.setDaysOfWeek(
                request.getDayOfWeek().stream()
                        .map(d -> DayOfWeek.valueOf(d.toUpperCase()))
                        .collect(Collectors.toSet())
        );        slot.setStartTime(request.getStartTime());
        slot.setEndTime(request.getEndTime());
        slot.setStartDate(request.getStartDate());
        slot.setEndDate(request.getEndDate());
        slot.setMaxCapacity(request.getMaxCapacity());

        // Fetch and set relations
        if (request.getCoachId() != null) {
            Coach coach = coachRepository.findById(request.getCoachId())
                    .orElseThrow(() -> new RuntimeException("Coach not found"));
            slot.setCoach(coach);
        }

        if (request.getLocationId() != null) {
            Location location = locationRepository.findById(request.getLocationId())
                    .orElseThrow(() -> new RuntimeException("Location not found"));
            slot.setLocation(location);
        }

        if (request.getLevelId() != null) {
            Level level = levelRepository.findById(request.getLevelId())
                    .orElseThrow(() -> new RuntimeException("Level not found"));
            slot.setLevel(level);
        }

        // Save and return DTO
        AvailableSlot saved = availableSlotRepository.save(slot);
        return availableSlotMapper.mapSlotToDTO(saved);    }

    @Override
    public AvailableSlot updateSlot(Long slotId, AvailableSlot slot) {
        return availableSlotRepository.findById(slotId).map(existing ->{
            existing.setLocation(slot.getLocation());
            existing.setCoach(slot.getCoach());
            existing.setDaysOfWeek(slot.getDaysOfWeek());
            existing.setStartTime(slot.getStartTime());
            existing.setEndTime(slot.getEndTime());
            existing.setStartDate(slot.getStartDate());
            existing.setEndDate(slot.getEndDate());
            existing.setMaxCapacity(slot.getMaxCapacity());
            existing.setLevel(slot.getLevel());
            return availableSlotRepository.save(existing);

        }).orElseThrow(()-> new RuntimeException("Slot not Found with id: "+ slotId));
    }

    @Override
    public void deleteSlot(Long slotId) {
        if(!availableSlotRepository.existsById(slotId))
        {
            throw new RuntimeException("Slot not found with id: "+ slotId);
        }
            availableSlotRepository.deleteById(slotId);
    }

    @Override
    public AvailableSlotDto getSlotById(Long slotId) {
       AvailableSlot availableSlot = availableSlotRepository.findById(slotId).
               orElseThrow(()-> new ResourceNotFoundException("NO Slot Available wit id:"+slotId));
       return AvailableSlotMapper.mapSlotToDTO(availableSlot);
    }

    @Override
    public List<AvailableSlot> getAllSlots() {
        return availableSlotRepository.findAll();
    }

    @Override
    public List<AvailableSlot> getSlotsByLocation(Long locationId) {
        return availableSlotRepository.findByLocation_LocationId(locationId);
    }
}
