package com.project.Swimming_coach.service;

import com.project.Swimming_coach.model.entity.Coach;

import java.util.List;
import java.util.Optional;

public interface CoachService {
    Coach addNewCoach(Coach coach);
    Coach editCoachInfo(Long id , Coach coach);
    void deleteCoach(Long id);
    Optional<Coach> getCoachById(Long id);
    List<Coach> getAllCoach();
    List<Coach> getCoachByName(String name);
}
