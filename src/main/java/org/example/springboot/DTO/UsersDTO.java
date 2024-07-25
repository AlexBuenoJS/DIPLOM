package org.example.springboot.dto;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.sql.Date;
import java.util.UUID;
import java.time.LocalDate;
import org.example.springboot.list.Country;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UsersDTO {
    private UUID id;
    private String surname;
    private String username;
    private String patronymic;
    private String city;
    private String country;
    private String nick;
    private String password;
    private Date usersdate;
    private String email;
}
