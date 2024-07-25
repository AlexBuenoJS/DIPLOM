package org.example.springboot.controller;

import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.UUID;
import java.time.LocalDate;
import org.example.springboot.list.City;
import org.example.springboot.dto.HomeDTO;
import org.example.springboot.object.Home;
import org.example.springboot.list.Country;
import jakarta.validation.ValidationException;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import org.example.springboot.service.HomeService;
import org.example.springboot.comment.HomeValidator;

@RestController
@RequiredArgsConstructor
@RequestMapping("/home")

public class HomeController {

    private final HomeService homeService;
    private final HomeValidator validator;

    @GetMapping("/searchHome")
    public List<Home> searchHomeByCity(City city){
        return homeService.searchHome(city);
    }

    @GetMapping("/createDefault")
    public void createDefaultHome(){
        homeService.addDefault();
    }

    @GetMapping("/getAllHomeDTO")
    public List<HomeDTO> getAllHomeDTO(){
        return homeService.getAllHomeDTO();
    }

    @PostMapping("/addHome")
    public HomeDTO addNewHome(@RequestBody HomeDTO homeDTO, BindingResult bindingResult){
        validator.validate(homeDTO, bindingResult);
        if (bindingResult.hasErrors()){
            throw new ValidationException();
        }
        return homeService.addNewHome(homeDTO);
    }

    @DeleteMapping("/deleteHome")
    public void deleteHome(UUID id){
        homeService.deleteHome(id);
    }

    @GetMapping("/searchHomesByCityAndCountry")
    public List<Home> searchHomeByCityAndCountry(City city, Country country, LocalDate due_date, Integer price, Integer rating){
        return homeService.searchHome(city,country,due_date,price,rating);
    }

    @PutMapping("/editHome")
    public HomeDTO editHome(@RequestBody HomeDTO homeDTO){
        return homeService.editHome(homeDTO);
    }
}
