package com.project.Swimming_coach.service;

import com.project.Swimming_coach.model.dto.CoachDTO;
import com.project.Swimming_coach.model.dto.CoachRequestDTO;
import com.project.Swimming_coach.model.entity.Coach;

import java.util.List;
import java.util.Optional;

public interface CoachService {
    CoachDTO addNewCoach(CoachRequestDTO coach);
    CoachDTO editCoachInfo(Long id , CoachRequestDTO coach);
    void deleteCoach(Long id);
    CoachDTO getCoachById(Long id);
    List<CoachDTO> getAllCoach();
    List<CoachDTO> getCoachByName(String name);
}
