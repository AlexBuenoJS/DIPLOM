package org.example.springboot.object;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.UUID;
import jakarta.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Table( name = "applicationlease")
public class ApplicationLease {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @OneToOne
    @JoinColumn(name = "housing_id")
    private Home home;
    @Column(name = "price")
    private Integer price;
    @Column(name = "rating")
    private Integer rating;
    @Column(name = "name")
    private String name;
}
