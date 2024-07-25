package org.example.springboot.mapper;

import org.mapstruct.*;
import org.example.springboot.dto.ApplicationLeaseDTO;
import org.example.springboot.object.ApplicationLease;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ApplicationLeaseMapper {
    ApplicationLeaseDTO toDto(ApplicationLease applicationLease);
    ApplicationLease  toEntity(ApplicationLeaseDTO applicationLeaseDTO);
    ApplicationLease merge(ApplicationLeaseDTO dto, @MappingTarget ApplicationLease target);
}
