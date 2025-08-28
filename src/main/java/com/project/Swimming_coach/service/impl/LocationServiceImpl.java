package com.project.Swimming_coach.service.impl;

import com.project.Swimming_coach.model.entity.Locations;
import com.project.Swimming_coach.repository.LocationRepository;
import com.project.Swimming_coach.service.LocationSerivce;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationSerivce {
    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Locations addNewLocation(Locations location) {
       return  locationRepository.save(location);
    }

    @Override
    public Locations updateLocation(Integer id, Locations updatedLocation) {
        return  locationRepository.findById( id).map(existingLocation -> {
            existingLocation.setLocationName(updatedLocation.getLocationName());
            existingLocation.setAddress(updatedLocation.getAddress());
            existingLocation.setCity(updatedLocation.getCity());
            existingLocation.setLatitude(updatedLocation.getLatitude());
            existingLocation.setLongitude(updatedLocation.getLongitude());
            existingLocation.setCapacity(updatedLocation.getCapacity());
            existingLocation.setDescription(updatedLocation.getDescription());
            existingLocation.setLevel(updatedLocation.getLevel());
            existingLocation.setImageUrl(updatedLocation.getImageUrl());
            return locationRepository.save(existingLocation);
        }).orElseThrow(() -> new RuntimeException("Location not found with id: " + id));

    }

    @Override
    public void deleteLocation(Integer id) {
        if(!locationRepository.existsById(id))
        {
            throw new RuntimeException("Location not found with id: " + id);
        }
        locationRepository.deleteById(id);
    }

    @Override
    public Optional<Locations> getLocation(Integer id) {
        return locationRepository.findById(id);
    }

    @Override
    public List<Locations> getAllLocations() {
        return locationRepository.findAll();
    }
}
