package org.example.springboot.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.Optional;
import java.util.stream.Collectors;
import org.example.springboot.list.City;
import org.example.springboot.object.Home;
import org.example.springboot.dto.ApplicationLeaseDTO;
import org.example.springboot.object.ApplicationLease;
import org.example.springboot.mapper.ApplicationLeaseMapper;
import org.example.springboot.repository.ApplicationLeaseRepository;

@Service
@RequiredArgsConstructor

public class ApplicationLeaseService {

    private final ApplicationLeaseRepository applicationLeaseRepository;
    private final ApplicationLeaseMapper applicationLeaseMapper;

    public void addDefault() {
        ApplicationLease applicationLease = ApplicationLease.builder()
                .name("Название аренды")
                .price(163000)
                .home(Home.builder()
                        .name("Дом")
                        .city(String.valueOf(City.valueOf("Ryazan")))
                        .availabilityCommunications("Вода горячая, газ отопления")
                        .build())
                .rating(1-10)
                .build();
        ApplicationLease savedEntity = applicationLeaseRepository.save(applicationLease);
        System.out.println("Успешно сохранен объект " + savedEntity);
    }

    public List<ApplicationLeaseDTO> getAllApplicationLeaseDTO() {
        return applicationLeaseRepository.findAll().stream()
                .map(applicationLease -> transformToDto(applicationLease))
                .collect(Collectors.toList());
    }

    private ApplicationLeaseDTO transformToDto(ApplicationLease applicationLease){
        return ApplicationLeaseDTO.builder()
                .id(applicationLease.getId())
                .home((applicationLease.getHome()))
                .name(applicationLease.getName())
                .price(applicationLease.getPrice())
                .rating(applicationLease.getRating())
                .build();
    }

    @Transactional

    public ApplicationLeaseDTO addNewApplicationLease(ApplicationLeaseDTO applicationLeasedto){
        ApplicationLease applicationLease = ApplicationLease.builder()
                .home(applicationLeasedto.getHome())
                .name(applicationLeasedto.getName())
                .rating(applicationLeasedto.getRating())
                .price(applicationLeasedto.getPrice())
                .build();
        ApplicationLease savedEntity = applicationLeaseRepository.save(applicationLease);
        return applicationLeaseMapper.toDto(savedEntity);
    }

    public void deleteApplication(UUID id){
        applicationLeaseRepository.deleteById(id);
    }

    @SneakyThrows
    public ApplicationLeaseDTO editApplicationLease(ApplicationLeaseDTO applicationLeaseDTO){
        ApplicationLease applicationLease = applicationLeaseRepository.findById(applicationLeaseDTO.getId())
                .orElseThrow(() -> new Exception("Объект не найден"));
        applicationLease.setHome(applicationLeaseDTO.getHome());
        applicationLease.setPrice(applicationLeaseDTO.getPrice());
        applicationLease.setName(applicationLeaseDTO.getName());
        return transformToDto(applicationLeaseRepository.save(applicationLease));
    }

    public Optional<ApplicationLease> getApplicationLeaseByName(String name) {
        return applicationLeaseRepository.findByName(name);
    }
}
