package com.project.Swimming_coach.controller;

import com.project.Swimming_coach.model.entity.Level;
import com.project.Swimming_coach.service.LevelService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/levels")
@PreAuthorize("hasRole('ADMIN')")
public class LevelController {
    private final LevelService levelService ;

    public LevelController(LevelService levelService) {
        this.levelService = levelService;
    }
    @PostMapping
    public ResponseEntity<Level> addLevel(@RequestBody Level level)
    {
        return ResponseEntity.ok(levelService.createLevel(level));
    }
    @PostMapping("/{id}")
    public  ResponseEntity<Level> editLevel(@PathVariable Long id , @RequestBody Level level )
    {
        return ResponseEntity.ok(levelService.updateLevel(id,level));
    }
    @GetMapping
    public ResponseEntity<List<Level>> getAllLevel()
    {
        return ResponseEntity.ok(levelService.getAllLevels());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Level> getLevelById(@PathVariable Long id)
    {
        return ResponseEntity.ok(levelService.getLevelById(id));
    }
    @DeleteMapping("/{id}")
    public void deleteLevel(@PathVariable Long id)
    {
        levelService.deleteLevel(id);
    }
}
