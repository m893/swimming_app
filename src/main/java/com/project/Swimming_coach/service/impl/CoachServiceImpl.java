package com.project.Swimming_coach.service.impl;

import com.project.Swimming_coach.mapper.CoachMapper;
import com.project.Swimming_coach.model.dto.CoachDTO;
import com.project.Swimming_coach.model.dto.CoachRequestDTO;
import com.project.Swimming_coach.model.entity.Coach;
import com.project.Swimming_coach.repository.CoachRepository;
import com.project.Swimming_coach.service.CoachService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CoachServiceImpl implements CoachService {
    private final CoachRepository coachRepository;

    public CoachServiceImpl(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    @Override
    public CoachDTO addNewCoach(CoachRequestDTO coach) {
        Coach coach1 = CoachMapper.toEntity(coach);
        Coach coach2 = coachRepository.save(coach1);
        return CoachMapper.toDTO(coach2);
    }

    @Override
    public CoachDTO editCoachInfo(Long id, CoachRequestDTO coach) {
        return coachRepository.findById(id).map(current ->{current.setName(coach.getName());
            current.setSpecialization(coach.getSpecialization());



            return CoachMapper.toDTO(coachRepository.save(current)) ;
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
    public CoachDTO getCoachById(Long id) {
        return coachRepository.findById(id).map(CoachMapper::toDTO).orElseThrow(()->new RuntimeException("Coach with id " + id + " not found"));
    }

    @Override
    public List<CoachDTO> getAllCoach() {
        return coachRepository.findAll()
                .stream()
                .map(CoachMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CoachDTO> getCoachByName(String name) {
        return coachRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(CoachMapper::toDTO)
                .collect(Collectors.toList());
    }
}
