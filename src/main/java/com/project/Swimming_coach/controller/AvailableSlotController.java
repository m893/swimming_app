package com.project.Swimming_coach.controller;

import com.project.Swimming_coach.model.entity.AvailableSlot;
import com.project.Swimming_coach.service.AvailableSlotService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.project.Swimming_coach.model.dto.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/slots")
@PreAuthorize("hasRole('ADMIN')")
public class AvailableSlotController {

    private final AvailableSlotService availableSlotService;

    public AvailableSlotController(AvailableSlotService availableSlotService) {
        this.availableSlotService = availableSlotService;
    }

    @PostMapping
    public ResponseEntity<AvailableSlotDTO> addSlot(@RequestBody SlotRequestDTO slot) {
        return ResponseEntity.ok(availableSlotService.addNewSlot(slot));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AvailableSlot> updateSlot(@PathVariable Long id,
                                                    @RequestBody AvailableSlot slot) {
        return ResponseEntity.ok(availableSlotService.updateSlot(id, slot));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSlot(@PathVariable Long id) {
        availableSlotService.deleteSlot(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvailableSlotDTO> getSlotById(@PathVariable Long id) {
        return ResponseEntity.ok(availableSlotService.getSlotById(id));

    }

    @GetMapping
    public ResponseEntity<List<AvailableSlot>> getAllSlots() {
        return ResponseEntity.ok(availableSlotService.getAllSlots());
    }
    @GetMapping("/location/{locationId}")
    public ResponseEntity<List<AvailableSlot>> getSlotsByLocation(@PathVariable Long locationId) {
        return ResponseEntity.ok(availableSlotService.getSlotsByLocation(locationId));
    }
}
