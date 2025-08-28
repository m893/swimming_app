package com.project.Swimming_coach.service.impl;
import com.project.Swimming_coach.model.entity.Level;
import com.project.Swimming_coach.repository.LevelRepository;
import com.project.Swimming_coach.service.LevelService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LevelServiceImpl implements LevelService {
    private final LevelRepository levelRepository;

    public LevelServiceImpl(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

    @Override
    public Level createLevel(Level level) {
        return levelRepository.save(level);
    }

    @Override
    public List<Level> getAllLevels() {
        return levelRepository.findAll();
    }

    @Override
    public Level getLevelById(Long id) {
        return levelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Level with id " + id + " not found"));
    }

    @Override
    public Level updateLevel(Long id, Level level) {
        return levelRepository.findById(id).map(current -> {
            current.setName(level.getName());
            current.setDescription(level.getDescription());

            if (level.getLocations() != null) {
                current.setLocations(level.getLocations());
            }
            if (level.getAvailableSlots() != null) {
                current.setAvailableSlots(level.getAvailableSlots());
            }

            return levelRepository.save(current);
        }).orElseThrow(() -> new RuntimeException("Level with id " + id + " not found"));
    }

    @Override
    public void deleteLevel(Long id) {
        if (!levelRepository.existsById(id)) {
            throw new RuntimeException("Level with id " + id + " not found");
        }
        levelRepository.deleteById(id);
    }
}
