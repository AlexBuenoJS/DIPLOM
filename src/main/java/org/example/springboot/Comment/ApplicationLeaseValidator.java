package org.example.springboot.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Optional;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.example.springboot.dto.ApplicationLeaseDTO;
import org.example.springboot.object.ApplicationLease;
import org.example.springboot.service.ApplicationLeaseService;

@Component
@RequiredArgsConstructor
public class ApplicationLeaseValidator implements Validator {
    private final ApplicationLeaseService applicationLeaseService;
    @Override
    public boolean supports(Class<?> clazz) {
        return ApplicationLeaseDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
     ApplicationLeaseDTO applicationLeaseDTO = (ApplicationLeaseDTO) target;
        Optional<ApplicationLease> applicationLease = applicationLeaseService.getApplicationLeaseByName(applicationLeaseDTO.getName());
        if (applicationLease.isPresent()){
            errors.rejectValue("name", "", "Такая аренда существует!");
        }
    }
}
