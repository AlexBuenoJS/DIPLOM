package org.example.springboot.object;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.sql.Date;
import java.util.Set;
import java.util.UUID;
import java.time.LocalDate;
import jakarta.persistence.*;
import org.example.springboot.list.Country;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "surname")
    private String surname;
    @Column(name = "username")
    private String username;
    @Column(name = "patronymic")
    private String patronymic;
    @Column(name = "city")
    private String city;
    private String country;//Country
    @Column(name = "nick")
    private String nick;
    @Column(name = "password")
    private String password;
    @Column(name = "user_date")
    private Date userdate;//LocalDate
    @Column(name = "email")
    private String email;
    @JoinTable(name = "user_role_relation",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Roles> roles;


}
