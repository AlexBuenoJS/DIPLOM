package org.example.springboot.controller;

import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.UUID;
import org.example.springboot.dto.UsersDTO;
import org.springframework.web.bind.annotation.*;
import org.example.springboot.service.UsersService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;
  //*******  private final UsersValidator validator;

    @GetMapping("/add-default")
      public void createDefaultUses(){
          usersService.addDefault();
      }

    @GetMapping("/get-all")
     public List<UsersDTO> getAllUsersDTO(){
      return usersService.getAllUsersDTO();
     }

    @PostMapping("/add-user")
    public UsersDTO addNewUsers(@RequestBody UsersDTO usersDTO ){
       return usersService.addNewUser(usersDTO);
    }

    @DeleteMapping("/delete-user")
    public void deleteUsers( UUID id){
        usersService.deleteUser(id);
    }

    @PutMapping("/edit")
    public UsersDTO edit(@RequestBody UsersDTO usersDTO){
        return usersService.editUser(usersDTO);
    }
}
