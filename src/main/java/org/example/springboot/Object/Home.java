package org.example.springboot.object;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.sql.Date;
import java.util.UUID;
import java.time.LocalDate;
import jakarta.persistence.*;
import org.example.springboot.list.City;
import org.example.springboot.list.Country;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "home")
public class Home {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "city")
    private String city;//City
    @Column(name = "availability_communications")
    private String availabilityCommunications;
    @Column(name = "country")
    private String country;//Country
    @Column(name = "rating")
    private Integer rating;
    @Column(name = "price")
    private Integer price;
    @Column(name = "due_date")
    private Date due_date;//LocalDate

    //public City getCity(){return city;}
}
