package org.example.springboot.controller;

import lombok.RequiredArgsConstructor;
import org.example.springboot.dto.RolesDTO;
import jakarta.validation.ValidationException;
import org.springframework.web.bind.annotation.*;
import org.example.springboot.service.RolesService;
import org.springframework.validation.BindingResult;
import org.example.springboot.comment.RolesValidator;

@RestController
@RequiredArgsConstructor
@RequestMapping("/roles")
public class RolesController {

    private final RolesService rolesService;
    private final RolesValidator validator;

    @PostMapping
    public void addRole(@RequestBody RolesDTO rolesDTO, BindingResult bindingResult) {
        if (!validator.supports(rolesDTO.getClass())) {
            throw new ValidationException("Unsupported type");
        }
        validator.validate(rolesDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            throw new ValidationException("Validation errors: " + bindingResult.getFieldErrors());
        }
        rolesService.addRoles(rolesDTO);
    }
}