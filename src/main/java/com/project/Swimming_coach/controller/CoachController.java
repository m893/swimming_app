package com.project.Swimming_coach.controller;

import com.project.Swimming_coach.model.dto.CoachDto;
import com.project.Swimming_coach.model.dto.CoachRequestDto;
import com.project.Swimming_coach.service.CoachService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/Coach")
@PreAuthorize("hasRole('ADMIN')")
public class CoachController {

    private final CoachService coachService;

    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }

    // ✅ Add new coach
    @PostMapping
    public ResponseEntity<CoachDto> addCoach(@Valid @RequestBody CoachRequestDto coachRequest) {
        CoachDto savedCoach = coachService.addNewCoach(coachRequest);
        return ResponseEntity.ok(savedCoach);
    }

    // ✅ Edit coach info
    @PutMapping("/{id}")
    public ResponseEntity<CoachDto> updateCoach(
            @PathVariable Long id,
            @Valid @RequestBody CoachRequestDto coachRequest) {
        CoachDto updatedCoach = coachService.editCoachInfo(id, coachRequest);
        return ResponseEntity.ok(updatedCoach);
    }

    // ✅ Delete coach
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCoach(@PathVariable Long id) {
        coachService.deleteCoach(id);
        return ResponseEntity.ok("Coach deleted successfully with id: " + id);
    }

    // ✅ Get coach by ID
    @GetMapping("/{id}")
    public ResponseEntity<CoachDto> getCoachById(@PathVariable Long id) {
        return ResponseEntity.ok(coachService.getCoachById(id));
    }

    // ✅ Get all coaches
    @GetMapping
    public ResponseEntity<List<CoachDto>> getAllCoaches() {
        return ResponseEntity.ok(coachService.getAllCoach());
    }

    // ✅ Search coaches by name
    @GetMapping("/search")
    public ResponseEntity<List<CoachDto>> searchCoachByName(@RequestParam String name) {
        return ResponseEntity.ok(coachService.getCoachByName(name));
    }
}
