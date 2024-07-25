package org.example.springboot.dto;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.sql.Date;
import java.util.UUID;

import org.example.springboot.object.Home;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class PlaceInformationDTO {
    private UUID id;
    private String name;
    private Home home;
    private Integer rating;
    private  String the_nearest_stop_metro;
    private Date due_date;
    private boolean activity;
}
