package com.project.Swimming_coach.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

public class AvailableSlotDTO {
    private Long slotId;
    private Set<String>  dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate startDate;
    private LocalDate endDate;
    private int maxCapacity;

    private String coachName;
    private String locationName;
    private String levelName;

    // Constructors
    public AvailableSlotDTO() {}

    public AvailableSlotDTO(Long slotId, Set<String> dayOfWeek, LocalTime startTime, LocalTime endTime, LocalDate startDate, LocalDate endDate, int maxCapacity, String coachName, String locationName, String levelName) {
        this.slotId = slotId;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startDate = startDate;
        this.endDate = endDate;
        this.maxCapacity = maxCapacity;
        this.coachName = coachName;
        this.locationName = locationName;
        this.levelName = levelName;
    }

    // Getters & Setters
    public Long getSlotId() { return slotId; }
    public void setSlotId(Long slotId) { this.slotId = slotId; }

    public Set<String> getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Set<String> dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public LocalTime getStartTime() { return startTime; }
    public void setStartTime(LocalTime startTime) { this.startTime = startTime; }

    public LocalTime getEndTime() { return endTime; }
    public void setEndTime(LocalTime endTime) { this.endTime = endTime; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public int getMaxCapacity() { return maxCapacity; }
    public void setMaxCapacity(int maxCapacity) { this.maxCapacity = maxCapacity; }

    public String getCoachName() { return coachName; }
    public void setCoachName(String coachName) { this.coachName = coachName; }

    public String getLocationName() { return locationName; }
    public void setLocationName(String locationName) { this.locationName = locationName; }

    public String getLevelName() { return levelName; }
    public void setLevelName(String levelName) { this.levelName = levelName; }
}
