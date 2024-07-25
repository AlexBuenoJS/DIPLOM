package org.example.springboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;
import java.util.UUID;
import java.util.Optional;
import java.time.LocalDate;
import java.util.stream.Collectors;
import org.example.springboot.list.City;
import org.example.springboot.dto.HomeDTO;
import org.example.springboot.object.Home;
import org.example.springboot.list.Country;
import org.example.springboot.mapper.HomeMapper;
import org.example.springboot.repository.HomeRepository;

@Service
@RequiredArgsConstructor

public class HomeService {

    private final HomeRepository homeRepository;
    private final HomeMapper homeMapper;
    private List<Home> homes;

    public  List<Home> searchHome(City city) {
      homes = homes.stream()
              .filter(home -> home.getCity().equals(city.name().toLowerCase().contains(city.name().toLowerCase())))
              .toList();
      return homes;
    }

    public void addDefault(){
        Home home = Home.builder()
                .name("Квартира")
                .city(String.valueOf(City.valueOf("Moscow")))//.city(City.valueOf("Moscow"))
                 .country(String.valueOf(Country.Russia))
                .availabilityCommunications("Вода горячая, газ отопления")
                .build();
        Home savedEntity = homeRepository.save(home);
        System.out.println("Успешно сохранен объект " + savedEntity);
    }

    public List<HomeDTO> getAllHomeDTO(){
        return homeRepository.findAll().stream()
                .map(home -> transformToDto(home))
                .collect(Collectors.toList());
    }

    private HomeDTO transformToDto(Home home){
        return HomeDTO.builder()
                .id(home.getId())
                .name(home.getName())
                .city(String.valueOf(City.valueOf(home.getCity())))
                .availability_communications(home.getAvailabilityCommunications())
                .build();
    }

    @Transactional

    public HomeDTO addNewHome(HomeDTO homeDTO) {
        Home home = Home.builder()
                .name(homeDTO.getName())
                .city(String.valueOf(homeDTO.getCity()))
                .country(String.valueOf(homeDTO.getCountry()))
                .availabilityCommunications(homeDTO.getAvailability_communications())
                .build();
        Home savedEntity = homeRepository.save(home);
        return homeMapper.toDto(savedEntity);
    }

    public void deleteHome(UUID id){
        homeRepository.deleteById(id);
    }

    public Optional<Home> getHomeByName(String name) {
        return homeRepository.findByName(name);
    }

    public  List<Home> searchHome(City city, Country country, LocalDate due_date, Integer price, Integer rating){
     homes = homes.stream()
             .filter(home -> home.getCity().equals(city.name().toLowerCase().contains(city.name().toLowerCase())))
             .filter(home -> home.getCountry().equals(country.name().toLowerCase().contains(country.name().toLowerCase())))
             .filter(home -> home.getDue_date().equals(due_date.plusDays(1)))
             .filter(home -> home.getPrice().equals(price.intValue()))
             .filter(home -> home.getRating().equals(rating.intValue()))
             .toList();
     return homes;
    }

    public HomeDTO editHome(HomeDTO homeDTO){
        Home home = Home.builder()
                .id(homeDTO.getId())
                .name(homeDTO.getName())
                .rating(homeDTO.getRating())
                .due_date(Date.valueOf(homeDTO.getDue_date().toLocalDate()))
                .price(homeDTO.getPrice())
                .country(String.valueOf(homeDTO.getCountry()))
                .city(String.valueOf(homeDTO.getCity()))
                .build();
        return transformToDto(homeRepository.save(home));
    }
}
