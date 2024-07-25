package org.example.springboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;
import java.util.UUID;
import java.time.LocalDate;
import java.util.stream.Collectors;
import org.example.springboot.dto.UsersDTO;
import org.example.springboot.object.Users;
import org.example.springboot.list.Country;
import org.example.springboot.mapper.UsersMapper;
import org.example.springboot.repository.UsersRepository;

@Service
@RequiredArgsConstructor

public class UsersService {

    private final UsersRepository usersRepository;
    private final UsersMapper usersMapper;

    public void addDefault(){
        Users users = Users.builder()
                .surname("Ardelyan")
                .username("Alex")
                .patronymic("Maximovich")
                .city("Ryazan")
                .country(String.valueOf(Country.Russia))
                .nick("Admin")
                .password("123456789")
                .userdate(Date.valueOf(LocalDate.of(2006,10,16)))
                .email("Steam.ardelyan@mail.ru")
                .build();
            Users savedEntity = usersRepository.save(users);
        System.out.println("Успешно сохранен объект " + savedEntity);
    }

    public List<UsersDTO> getAllUsersDTO(){
        return usersRepository.findAll().stream()
                .map(users -> transformToDto(users))
                .collect(Collectors.toList());
    }

    private UsersDTO transformToDto(Users users){
       return UsersDTO.builder()
                .id(users.getId())
                 .username(users.getUsername())
                .surname(users.getSurname())
                .patronymic(users.getPatronymic())
                .city(users.getCity())
                .country(String.valueOf(Country.valueOf(users.getCountry())))
                .nick(users.getNick())
                .password(String.valueOf(users.getPassword()))
                .usersdate(Date.valueOf(users.getUserdate().toLocalDate()))
                .email(users.getEmail())
                .build();
    }

    @Transactional

    public UsersDTO addNewUser(UsersDTO userDTO) {

        Users users = Users.builder()
                .surname(userDTO.getSurname())
                .username(userDTO.getUsername())
                .patronymic(userDTO.getPatronymic())
                .city(userDTO.getCity())
                .country(String.valueOf(userDTO.getCountry()))
                .nick(userDTO.getNick())
                .password(String.valueOf(userDTO.getPassword()))
                .userdate(Date.valueOf(userDTO.getUsersdate().toLocalDate()))
                .email(userDTO.getEmail())
                .build();
        Users savedEntity = usersRepository.save(users);
        return usersMapper.toDto(savedEntity);
    }

    public void deleteUser(UUID id){
        usersRepository.deleteById(id);
    }
     public UsersDTO editUser(UsersDTO userDTO) {
       Users users = Users.builder()
                       .id(userDTO.getId())
                       .surname(userDTO.getSurname())
                       .username(userDTO.getUsername())
                       .patronymic(userDTO.getPatronymic())
                       .city(userDTO.getCity())
                       .country(String.valueOf(userDTO.getCountry()))
                       .nick(userDTO.getNick())
                       .password(String.valueOf(userDTO.getPassword()))
                       .email(userDTO.getEmail())
                       .build();
       return transformToDto(usersRepository.save(users));
     }
}
