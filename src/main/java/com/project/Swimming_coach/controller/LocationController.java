package com.project.Swimming_coach.controller;

import com.project.Swimming_coach.model.dto.LocationDto;
import com.project.Swimming_coach.model.entity.Locations;
import com.project.Swimming_coach.service.LocationSerivce;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/locations")
@PreAuthorize("hasRole('ADMIN')")
public class LocationController {
    private final LocationSerivce locationSerivce ;


    public LocationController(LocationSerivce locationSerivce) {
        this.locationSerivce = locationSerivce;
    }
    @PostMapping
    public ResponseEntity<LocationDto> addLocation( @Valid  @RequestBody LocationDto locations)
    {
        return ResponseEntity.ok(locationSerivce.addNewLocation(locations));
    }
    @PutMapping("/{id}")
    public ResponseEntity<LocationDto> editLocation(@PathVariable Integer id ,@Valid @RequestBody LocationDto locations)
    {
        return ResponseEntity.ok(locationSerivce.updateLocation(id,locations));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable Integer id)
    {
        locationSerivce.deleteLocation(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<LocationDto> getLocation(@PathVariable Integer id)
    {
        LocationDto dto = locationSerivce.getLocation(id);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }
    @GetMapping
    public ResponseEntity<List<LocationDto>> getAllLocations()
    {
        return ResponseEntity.ok(locationSerivce.getAllLocations());
    }

}
