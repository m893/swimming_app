package com.project.Swimming_coach.service;
import com.project.Swimming_coach.model.entity.Level;

import java.util.List;

public interface LevelService {
    Level createLevel(Level level);

    List<Level> getAllLevels();

    Level getLevelById(Long id);

    Level updateLevel(Long id, Level level);

    void deleteLevel(Long id);
}
