package com.project.Swimming_coach.service;

import com.project.Swimming_coach.model.dto.LocationDto;
import com.project.Swimming_coach.model.entity.Locations;

import java.util.List;
import java.util.Optional;

public interface LocationSerivce {
    LocationDto addNewLocation(LocationDto location);
    LocationDto updateLocation(Integer id , LocationDto locations);
    void deleteLocation(Integer id);
    LocationDto getLocation(Integer id);
    List<LocationDto> getAllLocations();
}
