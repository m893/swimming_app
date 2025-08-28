package com.project.Swimming_coach.service;

import com.project.Swimming_coach.model.entity.Locations;

import java.util.List;
import java.util.Optional;

public interface LocationSerivce {
    Locations addNewLocation(Locations location);
    Locations updateLocation(Integer id , Locations locations);
    void deleteLocation(Integer id);
    Optional<Locations> getLocation(Integer id);
    List<Locations> getAllLocations();
}
