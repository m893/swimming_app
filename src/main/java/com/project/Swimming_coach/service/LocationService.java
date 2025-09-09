package com.project.Swimming_coach.service;

import com.project.Swimming_coach.model.dto.LocationDto;

import java.util.List;

public interface LocationService {
    LocationDto addNewLocation(LocationDto location);
    LocationDto updateLocation(Integer id , LocationDto locations);
    void deleteLocation(Integer id);
    LocationDto getLocation(Integer id);
    List<LocationDto> getAllLocations();
}
