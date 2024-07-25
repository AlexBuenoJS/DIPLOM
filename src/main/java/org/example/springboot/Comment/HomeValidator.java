package org.example.springboot.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Optional;
import org.example.springboot.dto.HomeDTO;
import org.example.springboot.object.Home;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.example.springboot.service.HomeService;

@Component
@RequiredArgsConstructor
public class HomeValidator implements Validator {
    private final HomeService homeService;

    @Override
    public boolean supports(Class<?> clazz) {
        return HomeDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        HomeDTO homeDTO = (HomeDTO) target;
        Optional<Home> home = homeService.getHomeByName(homeDTO.getName());
        if (home.isPresent()){
            errors.rejectValue("name","","Такой жильё существует!");
        }
    }
}
