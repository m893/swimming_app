package com.project.Swimming_coach.service.impl;

import com.project.Swimming_coach.model.entity.Coach;
import com.project.Swimming_coach.repository.CoachRepository;
import com.project.Swimming_coach.service.CoachService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CoachServiceImpl implements CoachService {
    private final CoachRepository coachRepository;

    public CoachServiceImpl(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    @Override
    public Coach addNewCoach(Coach coach) {
        return coachRepository.save(coach);
    }

    @Override
    public Coach editCoachInfo(Long id, Coach coach) {
        return coachRepository.findById(id).map(current ->{current.setName(coach.getName());
            current.setSpecialization(coach.getSpecialization());


            if (coach.getAvailableSlots() != null) {
                current.setAvailableSlots(coach.getAvailableSlots());
            }

            return coachRepository.save(current);
        }).orElseThrow(() -> new RuntimeException("Coach with id " + id + " not found"));

    }

    @Override
    public void deleteCoach(Long id) {
            if(!coachRepository.existsById(id))
            {
                throw  new RuntimeException("coach not found with id: " + id);
            }
            coachRepository.deleteById(id);
    }

    @Override
    public Optional<Coach> getCoachById(Long id) {
        return coachRepository.findById(id);
    }

    @Override
    public List<Coach> getAllCoach() {
        return coachRepository.findAll();
    }

    @Override
    public List<Coach> getCoachByName(String name) {
        return coachRepository.findByNameContainingIgnoreCase(name);
    }
}
