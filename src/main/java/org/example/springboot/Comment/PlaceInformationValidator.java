package org.example.springboot.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Optional;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.example.springboot.dto.PlaceInformationDTO;
import org.example.springboot.object.PlaceInformation;
import org.example.springboot.service.PlaceInformationService;

@Component
@RequiredArgsConstructor
public class PlaceInformationValidator implements Validator {
    private final PlaceInformationService placeInformationService;
    @Override
    public boolean supports(Class<?> clazz) {
        return PlaceInformationDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
     PlaceInformationDTO placeInformationDTO = (PlaceInformationDTO) target;
        Optional<PlaceInformation> placeAds = placeInformationService.getPlaceInformationByName(placeInformationDTO.getName());
        if (placeAds.isPresent()){
            errors.rejectValue("name","","Такой обьявления существует!");
        }
    }

}
