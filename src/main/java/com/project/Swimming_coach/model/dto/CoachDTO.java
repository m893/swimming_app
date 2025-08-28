package com.project.Swimming_coach.model.dto;

import java.util.List;

public class CoachDTO {
    private Long id ;
    private String name ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String specialization;
    private List<Long> availableSlots ;

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

    public List<Long> getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(List<Long> availableSlots) {
        this.availableSlots = availableSlots;
    }
}
