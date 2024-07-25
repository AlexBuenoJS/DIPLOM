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
import org.example.springboot.object.Home;
import org.example.springboot.object.PlaceInformation;
import org.example.springboot.dto.PlaceInformationDTO;
import org.example.springboot.mapper.PlaceInformationMapper;
import org.example.springboot.repository.PlaceInformationRepository;

@Service
@RequiredArgsConstructor

public class PlaceInformationService {

    private final PlaceInformationRepository placeInformationRepository;
    private  final PlaceInformationMapper placeInformationMapper;

    public void addDefault(){
        PlaceInformation placeInformation = PlaceInformation.builder()
                .due_date(Date.valueOf(LocalDate.of(2023, 2, 28)))
                .the_nearest_stop_metro("Красная звезда, Локомотив")
                .name("Название обьявления")
                .rating(1-5)
                .home(Home.builder()
                        .name("Квартира")
                        .city(String.valueOf(City.valueOf("Moscow")))
                        .availabilityCommunications("Вода горячая, газ отопления")
                        .build())
                .build();
        PlaceInformation savedEntity = placeInformationRepository.save(placeInformation);
        System.out.println("Успешно сохранен объект " + savedEntity);
    }

    public List<PlaceInformationDTO> getAllPlaceInformationDTO(){
        return placeInformationRepository.findAll().stream()
                .map(placeInformation ->transformToDto(placeInformation) )
                .collect(Collectors.toList());
    }

    private PlaceInformationDTO transformToDto(PlaceInformation placeInformation){
        return PlaceInformationDTO.builder()
                .id(placeInformation.getId())
                .name(placeInformation.getName())
                .due_date(Date.valueOf(placeInformation.getDue_date().toLocalDate()))
                .rating(placeInformation.getRating())
                .home((placeInformation.getHome()))
                .build();
    }

    @Transactional

    public PlaceInformationDTO addNewPlaceInformation(PlaceInformationDTO placeInformationDTO){
        PlaceInformation.PlaceInformationBuilder builder = PlaceInformation.builder();
        builder.name(placeInformationDTO.getName());
        builder.home(placeInformationDTO.getHome());
        builder.rating(placeInformationDTO.getRating());
        builder.the_nearest_stop_metro(placeInformationDTO.getThe_nearest_stop_metro());
        builder.due_date(Date.valueOf(placeInformationDTO.getDue_date().toLocalDate()));
        PlaceInformation placeInformation = builder
                .build();
        PlaceInformation savedEntity = placeInformationRepository.save(placeInformation);
        return placeInformationMapper.toDo(savedEntity);
    }

    public PlaceInformationDTO editApplicationLease(PlaceInformationDTO placeInformationDTO){
        PlaceInformation placeInformation = PlaceInformation.builder()
                .id(placeInformationDTO.getId())
                .rating(placeInformationDTO.getRating())
                .the_nearest_stop_metro(placeInformationDTO.getThe_nearest_stop_metro())
                .build();
        return transformToDto(placeInformationRepository.save(placeInformation));
    }

    public void deletePlaceInformation(UUID id){
        placeInformationRepository.deleteById(id);
    }

    public Optional<PlaceInformation> getPlaceInformationByName(String name) {
        return placeInformationRepository.findByName(name);
    }

    public boolean activityPlaceInformation(){
        if (true){
            System.out.println("Жилье уже забронированно");
        }else {
            System.out.println("Объявление актуально");
        }
        if (false){
            System.out.println("Жилье не забронираванно");
        }else {
            System.out.println("Объявление не актуально");
        }
        return  false;
    }
}
