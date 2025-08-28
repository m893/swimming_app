package com.project.Swimming_coach.controller;

import com.project.Swimming_coach.model.entity.Locations;
import com.project.Swimming_coach.service.LocationSerivce;
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
    public ResponseEntity<Locations> addLocation(@RequestBody Locations locations)
    {
        return ResponseEntity.ok(locationSerivce.addNewLocation(locations));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Locations> editLocation(@PathVariable Integer id ,@RequestBody Locations locations)
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
    public ResponseEntity<Locations> getLocation(@PathVariable Integer id)
    {
        return locationSerivce.getLocation(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping
    public ResponseEntity<List<Locations>> getAllLocations()
    {
        return ResponseEntity.ok(locationSerivce.getAllLocations());
    }

}
