package com.project.Swimming_coach.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "trainees")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Trainees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "full_name", nullable = false, length = 100)
    private String fullName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Trainees parent;
}
