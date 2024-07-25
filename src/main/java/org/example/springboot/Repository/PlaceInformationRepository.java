package org.example.springboot.repository;

import org.springframework.stereotype.Repository;
import java.util.UUID;
import java.util.Optional;
import org.example.springboot.object.PlaceInformation;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository

public interface PlaceInformationRepository extends JpaRepository<PlaceInformation, UUID> {
    Optional<PlaceInformation> findByName(String name);
}
