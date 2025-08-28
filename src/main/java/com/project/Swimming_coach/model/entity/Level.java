package com.project.Swimming_coach.model.entity;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "levels")
public class Level {
    public Level() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long levelId;

    @Column(nullable = false, length = 50, unique = true)
    private String name; // Beginner, Intermediate, Advanced...

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "level")
    private List<Locations> locations;

    @OneToMany(mappedBy = "level")
    private List<AvailableSlot> availableSlots;

    public Long getLevelId() {
        return levelId;
    }

    public void setLevelId(Long levelId) {
        this.levelId = levelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Locations> getLocations() {
        return locations;
    }

    public void setLocations(List<Locations> locations) {
        this.locations = locations;
    }

    public List<AvailableSlot> getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(List<AvailableSlot> availableSlots) {
        this.availableSlots = availableSlots;
    }
}
