package org.example.springboot.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.example.springboot.dto.UsersDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.example.springboot.service.UsersService;

@Component
@RequiredArgsConstructor
public class UsersValidator implements Validator {
    private final UsersService usersService;

    @Override
    public boolean supports(Class<?> clazz) {

        return UsersDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
       // UsersDTO usersDTO = (UsersDTO) target;
        // Optional<Users> users = usersService.getUsersByName(usersDTO.getUsername());

      //  if (users.isPresent()) {
            //errors.rejectValue("name", "", "Такой пользователь существует!");

        //}
    }
}
