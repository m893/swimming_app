package com.project.Swimming_coach.service;

import com.project.Swimming_coach.model.dto.CoachDto;
import com.project.Swimming_coach.model.dto.CoachRequestDto;

import java.util.List;

public interface CoachService {
    CoachDto addNewCoach(CoachRequestDto coach);
    CoachDto editCoachInfo(Long id , CoachRequestDto coach);
    void deleteCoach(Long id);
    CoachDto getCoachById(Long id);
    List<CoachDto> getAllCoach();
    List<CoachDto> getCoachByName(String name);
}
