package org.example.springboot.dto;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.UUID;
import org.example.springboot.object.Home;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ApplicationLeaseDTO {
    private UUID id;
    private Home home;
    private Integer price;
    private Integer rating;
    private String name;
}
