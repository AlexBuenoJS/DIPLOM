package org.example.springboot.controller;

import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.UUID;
import jakarta.validation.ValidationException;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import org.example.springboot.dto.PlaceInformationDTO;
import org.example.springboot.service.PlaceInformationService;
import org.example.springboot.comment.PlaceInformationValidator;

@RestController
@RequiredArgsConstructor
@RequestMapping("/placeads")

public class PlaceInformationController {

    private final PlaceInformationService placeInformationService;
    private final PlaceInformationValidator validator;

    @GetMapping("/createDefault")
    public void createDefaultPlaceInformation(){
        placeInformationService.addDefault();
    }

    @GetMapping("/getAllPlaceInformationDTO")
    public List<PlaceInformationDTO> getAllPlaceInformationDTO(){
        return placeInformationService.getAllPlaceInformationDTO();
    }

    @PostMapping("/addPlaceAds")
    public PlaceInformationDTO addNewPlaceInformation(@RequestBody PlaceInformationDTO placeInformationDTO, BindingResult bindingResult){
        validator.validate(placeInformationDTO, bindingResult);
        if (bindingResult.hasErrors()){
            throw new ValidationException();
        }
        return placeInformationService.addNewPlaceInformation(placeInformationDTO);
    }

    @DeleteMapping("/deletePlaceAds")
    public void deletePlaceInformation(UUID id){
        placeInformationService.deletePlaceInformation(id);
    }

    @GetMapping("/checkActivityPlaceAds")
    public boolean checkActivityPlaceInformation(){
        return placeInformationService.activityPlaceInformation();
    }
    @PutMapping("/edit")
    public PlaceInformationDTO edit(@RequestBody PlaceInformationDTO placeInformationDTO){
        return placeInformationService.editApplicationLease(placeInformationDTO);
    }
}
