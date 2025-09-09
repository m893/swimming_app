package com.project.Swimming_coach.model.dto;

import jakarta.validation.constraints.*;

import java.util.List;

public class LocationDto {


    private Integer id;
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 100, message = "Name must be between 3 and 100 characters")
    private String name;
    @NotBlank(message = "Address is required")
    private String address;
    @NotBlank(message = "City is required")
    private String city;
    @NotNull(message = "Latitude is required")
    @DecimalMin(value = "-90.0", message = "Latitude must be >= -90.0")
    @DecimalMax(value = "90.0", message = "Latitude must be <= 90.0")
    private Double latitude;
    @NotNull(message = "Longitude is required")
    @DecimalMin(value = "-180.0", message = "Longitude must be >= -180.0")
    @DecimalMax(value = "180.0", message = "Longitude must be <= 180.0")
    private Double longitude;
    @NotNull(message = "Capacity is required")
    @Positive(message = "Capacity must be greater than 0")
    @Max(value = 20, message = "Capacity cannot exceed 25")
    private Integer capacity;
    @Size(max = 500, message = "Description cannot exceed 500 characters")
    private String description;

    @NotNull(message = "Level ID is required")
    private Long levelId;
    @Pattern(
            regexp = "^(https?|ftp)://[^\\s/$.?#].[^\\s]*$",
            message = "Image URL must be a valid URL"
    )
    private String imageUrl;

    public List<AvailableSlotDto> getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(List<AvailableSlotDto> availableSlots) {
        this.availableSlots = availableSlots;
    }

    private List<AvailableSlotDto> availableSlots;


    public LocationDto(Integer id, String name, String address, String city, Double latitude, Double longitude, Integer capacity, String description, Long levelId, String imageUrl, List<AvailableSlotDto> availableSlots) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
        this.capacity = capacity;
        this.description = description;
        this.levelId = levelId;
        this.imageUrl = imageUrl;
        this.availableSlots = availableSlots;
    }

    public LocationDto() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getLevelId() {
        return levelId;
    }

    public void setLevelId(Long levelId) {
        this.levelId = levelId;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    @Override
    public String toString() {
        return "LocationDto{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", capacity=" + capacity +
                ", description='" + description + '\'' +
                ", levelId=" + levelId +
                '}';
    }
}
