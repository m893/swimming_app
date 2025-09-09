package com.project.Swimming_coach.controller;

import com.project.Swimming_coach.model.dto.LocationDto;
import com.project.Swimming_coach.service.LocationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/locations")
@PreAuthorize("hasRole('ADMIN')")
public class LocationController {
    private final LocationService locationService;


    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }
    @PostMapping
    public ResponseEntity<LocationDto> addLocation( @Valid  @RequestBody LocationDto locations)
    {
        return ResponseEntity.ok(locationService.addNewLocation(locations));
    }
    @PutMapping("/{id}")
    public ResponseEntity<LocationDto> editLocation(@PathVariable Integer id ,@Valid @RequestBody LocationDto locations)
    {
        return ResponseEntity.ok(locationService.updateLocation(id,locations));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable Integer id)
    {
        locationService.deleteLocation(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<LocationDto> getLocation(@PathVariable Integer id)
    {
        LocationDto dto = locationService.getLocation(id);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }
    @GetMapping
    public ResponseEntity<List<LocationDto>> getAllLocations()
    {
        return ResponseEntity.ok(locationService.getAllLocations());
    }

}
