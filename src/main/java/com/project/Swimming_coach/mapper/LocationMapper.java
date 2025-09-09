package com.project.Swimming_coach.mapper;

import com.project.Swimming_coach.model.dto.AvailableSlotDto;
import com.project.Swimming_coach.model.dto.LocationDto;
import com.project.Swimming_coach.model.entity.Location;
import com.project.Swimming_coach.model.entity.Level;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class LocationMapper {


    public static LocationDto toDto(Location location) {
        if (location == null) {
            return null;
        }
        LocationDto dto = new LocationDto();
        dto.setId(location.getLocationId());
        dto.setName(location.getLocationName());
        dto.setAddress(location.getAddress());
        dto.setCity(location.getCity());
        dto.setLatitude(location.getLatitude() != null ? location.getLatitude().doubleValue() : null);
        dto.setLongitude(location.getLongitude() != null ? location.getLongitude().doubleValue() : null);
        dto.setCapacity(location.getCapacity());
        dto.setDescription(location.getDescription());
        dto.setLevelId(location.getLevel() != null ? location.getLevel().getLevelId() : null);
        dto.setImageUrl(location.getImageUrl());

        if (location.getAvailableSlots() != null) {
            List<AvailableSlotDto> slotDTOs = location.getAvailableSlots()
                    .stream()
                    .map(AvailableSlotMapper::mapSlotToDTO)
                    .collect(Collectors.toList());
            dto.setAvailableSlots(slotDTOs);
        }

        return dto;
    }

    // DTO → Entity
    public static Location toEntity(LocationDto dto, Level level) {
        if (dto == null) return null;

        Location entity = new Location();
        entity.setLocationId(dto.getId());
        entity.setLocationName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setCity(dto.getCity());
        entity.setLatitude(dto.getLatitude() != null ? BigDecimal.valueOf(dto.getLatitude()) : null);
        entity.setLongitude(dto.getLongitude() != null ? BigDecimal.valueOf(dto.getLongitude()) : null);
        entity.setCapacity(dto.getCapacity());
        entity.setDescription(dto.getDescription());
        entity.setImageUrl(dto.getImageUrl());
        entity.setLevel(level); // you’ll fetch Level entity in service layer
        return entity;
    }
}
