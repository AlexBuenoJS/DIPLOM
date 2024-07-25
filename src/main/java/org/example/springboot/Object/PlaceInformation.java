package org.example.springboot.object;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.sql.Date;
import java.util.UUID;

import jakarta.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "placeads")
public class PlaceInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "name")
    private String name;
    @OneToOne
    @JoinColumn(name = "housing_id")
    private Home home;
    @Column(name = "the_nearest_stop_metro")
    private  String the_nearest_stop_metro;
    @Column(name = "due_date")
    private Date due_date;//LocalDate
    @Column(name = "rating")
    private Integer rating;
    @Column(name = "activity")
    private boolean activity;
}
