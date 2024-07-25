package org.example.springboot.mapper;

import org.mapstruct.*;
import org.example.springboot.dto.PlaceInformationDTO;
import org.example.springboot.object.PlaceInformation;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface PlaceInformationMapper {
    PlaceInformationDTO toDo(PlaceInformation placeInformation);
    PlaceInformation toEntity(PlaceInformationDTO placeInformationDTO);
     PlaceInformation merge(PlaceInformationDTO dto, @MappingTarget PlaceInformation target);
}
