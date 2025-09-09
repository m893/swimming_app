package com.project.Swimming_coach.service.impl;

import com.project.Swimming_coach.exception.ResourceNotFoundException;
import com.project.Swimming_coach.mapper.LocationMapper;
import com.project.Swimming_coach.model.dto.LocationDto;
import com.project.Swimming_coach.model.entity.Level;
import com.project.Swimming_coach.model.entity.Location;
import com.project.Swimming_coach.repository.LevelRepository;
import com.project.Swimming_coach.repository.LocationRepository;
import com.project.Swimming_coach.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;
    private final LevelRepository levelRepository;

    public LocationServiceImpl(LocationRepository locationRepository, LevelRepository levelRepository) {
        this.locationRepository = locationRepository;
        this.levelRepository = levelRepository;
    }

    @Override
    public LocationDto addNewLocation(LocationDto dto ) {
        Level level = null ;
        if(dto.getLevelId() != null)
        {
            level = levelRepository.findById(dto.getLevelId()).orElseThrow(()-> new ResourceNotFoundException("Level Not Found"));
        }
       Location location = LocationMapper.toEntity(dto,level);
       Location location1 = locationRepository.save(location);
       return LocationMapper.toDto(location1);
    }

    @Override
    public LocationDto updateLocation(Integer id, LocationDto dto) {
        Location existing = locationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Location not found"));

        // update fields
        existing.setLocationName(dto.getName());
        existing.setAddress(dto.getAddress());
        existing.setCity(dto.getCity());
        if (dto.getLatitude() != null) {
            existing.setLatitude(java.math.BigDecimal.valueOf(dto.getLatitude().doubleValue()));
        }
        if (dto.getLongitude() != null) {
            existing.setLongitude(java.math.BigDecimal.valueOf(dto.getLongitude().doubleValue()));
        }
        existing.setCapacity(dto.getCapacity());
        existing.setDescription(dto.getDescription());

        if (dto.getLevelId() != null) {
            Level level = levelRepository.findById(dto.getLevelId())
                    .orElseThrow(() -> new RuntimeException("Level not found"));
            existing.setLevel(level);
        } else {
            existing.setLevel(null);
        }

        Location updated = locationRepository.save(existing);
        return LocationMapper.toDto(updated);
    }

    @Override
    public void deleteLocation(Integer id) {
        if(!locationRepository.existsById(id))
        {
            throw new ResourceNotFoundException("Location not found with id: " + id);
        }
        locationRepository.deleteById(id);
    }

    @Override
    public LocationDto getLocation(Integer id) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Location not found with id: " + id));
        return LocationMapper.toDto(location);
    }

    @Override
    public List<LocationDto> getAllLocations() {
        return locationRepository.findAll()
                .stream()
                .map(LocationMapper::toDto)
                .collect(Collectors.toList());
    }
}
