package org.example.springboot.mapper;

import org.mapstruct.*;
import org.example.springboot.dto.UsersDTO;
import org.example.springboot.object.Users;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface UsersMapper {
      UsersDTO toDto(Users users);
      Users toEntity(UsersDTO usersDTO);
      Users marge(UsersDTO dto, @MappingTarget Users entity);
}
