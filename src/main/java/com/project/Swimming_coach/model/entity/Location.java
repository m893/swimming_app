package com.project.Swimming_coach.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="locations")
public class Location {
    public Location() {
    }

    public Location(String locationName, Integer locationId, String address, String city, BigDecimal  latitude, BigDecimal  longitude, Integer capacity, String description, Level level, List<AvailableSlot> availableSlots) {
        this.locationName = locationName;
        this.locationId = locationId;
        this.address = address;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
        this.capacity = capacity;
        this.description = description;
        this.level = level;
        this.availableSlots = availableSlots;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer locationId ;
    @Column(nullable = false , length = 100)
    private String locationName ;
    @Column(nullable = false , length = 255)
    private String address ;
    @Column(nullable = false , length = 100)
    private String city ;
    @Column(precision = 10, scale = 6)
    private BigDecimal  latitude;

    @Column(precision = 10, scale = 6)
    private BigDecimal longitude;

    private Integer capacity;


    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "level_id")
    private Level level;;
    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AvailableSlot> availableSlots;
    @Column(length = 500)
    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
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

    public BigDecimal  getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public BigDecimal  getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal  longitude) {
        this.longitude = longitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public List<AvailableSlot> getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(List<AvailableSlot> availableSlots) {
        this.availableSlots = availableSlots;
    }
}
