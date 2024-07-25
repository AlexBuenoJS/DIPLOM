package org.example.springboot.dto;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.sql.Date;
import java.util.UUID;
import java.time.LocalDate;
import org.example.springboot.list.City;
import org.example.springboot.list.Country;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class HomeDTO {
    private UUID id;
    private String name;
    private String city;
    private String country;
    private Integer rating;
    private String availability_communications;
    private Integer price;
    private Date due_date;
}
