package org.example.springboot.repository;

import org.springframework.stereotype.Repository;
import java.util.UUID;
import java.util.Optional;
import org.example.springboot.object.Home;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository

public interface HomeRepository extends JpaRepository<Home, UUID> {
    Optional<Home> findByName(String name);
}
