package org.example.springboot.controller;

import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.UUID;
import jakarta.validation.ValidationException;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import org.example.springboot.dto.ApplicationLeaseDTO;
import org.example.springboot.service.ApplicationLeaseService;
import org.example.springboot.comment.ApplicationLeaseValidator;

@RestController
@RequiredArgsConstructor
@RequestMapping("/applicationlease")

public class ApplicationLeaseController {

    private final ApplicationLeaseService applicationLeaseService;
    private final ApplicationLeaseValidator applicationLeaseValidator;

    @GetMapping("/addDefault")
    public void createDefaultApplicationLease() {
        applicationLeaseService.addDefault();
    }

    @GetMapping("/getAll")
    public List<ApplicationLeaseDTO> getAllApplicationLeaseDTO() {
        return applicationLeaseService.getAllApplicationLeaseDTO();
    }

    @PostMapping("/addApplicationRent")
    public ApplicationLeaseDTO addNewApplicationLease(@RequestBody ApplicationLeaseDTO applicationLeaseDTO, BindingResult bindingResult) {
        applicationLeaseValidator.validate(applicationLeaseDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }
        return applicationLeaseService.addNewApplicationLease(applicationLeaseDTO);
    }

    @DeleteMapping("/deleteApplication")
    public void deleteApplicationLease(UUID id) {
        applicationLeaseService.deleteApplication(id);
    }

    @PutMapping("/editApplicationLease")
    public ApplicationLeaseDTO editApplicationLease(@RequestBody ApplicationLeaseDTO applicationLeaseDTO) {
        return applicationLeaseService.editApplicationLease(applicationLeaseDTO);
    }
}
