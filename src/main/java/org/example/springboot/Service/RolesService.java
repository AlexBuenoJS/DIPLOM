package org.example.springboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.Optional;
import java.util.stream.Collectors;
import org.example.springboot.dto.RolesDTO;
import org.example.springboot.object.Roles;
import org.example.springboot.list.RolesType;
import org.example.springboot.repository.RolesRepository;

@Service
@RequiredArgsConstructor

public class RolesService {

     private final RolesRepository rolesRepository;

     public void addRoles(RolesDTO roles){
         rolesRepository.save(Roles.builder()
                 .rolesType(RolesType.fromString(roles.getRoles()))
                 .build());
     }

     public List<Roles> findAll(){
         return rolesRepository.findAll();
   }

    public void getRoles(List<UUID> rolesIds){
        rolesIds.stream()
                .map(rolesRepository ::findById)
                .map(Optional::get)
                .collect(Collectors.toSet());
    }
}
