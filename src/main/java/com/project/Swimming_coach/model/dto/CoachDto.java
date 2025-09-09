package com.project.Swimming_coach.model.dto;

import java.util.List;

public class CoachDto {
    private Long id ;
    private String name ;
    private String specialization;
    private List<AvailableSlotDto> availableSlots ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public List<AvailableSlotDto> getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(List<AvailableSlotDto> availableSlots) {
        this.availableSlots = availableSlots;
    }
}
