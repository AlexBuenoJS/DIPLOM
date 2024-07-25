package org.example.springboot.mapper;

import org.mapstruct.*;
import org.example.springboot.dto.HomeDTO;
import org.example.springboot.object.Home;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface HomeMapper {
  HomeDTO toDto(Home home);
  Home toEntity(HomeDTO homeDTO);
  Home merge(HomeDTO dto, @MappingTarget Home target);
}
