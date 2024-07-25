package org.example.springboot.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.example.springboot.dto.RolesDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.example.springboot.service.RolesService;

@Component
@RequiredArgsConstructor
public class RolesValidator implements Validator {

    private final RolesService rolesService;


    @Override
    public boolean supports(Class<?> clazz) {
        return RolesDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
     RolesDTO targetRoles = (RolesDTO) target;

     boolean exists = rolesService.findAll().stream()
             .anyMatch(roles->targetRoles.getRoles().equals(roles.getRolesType().name()));
     if (exists){
        errors.rejectValue("role", "");
      }
    }
}
