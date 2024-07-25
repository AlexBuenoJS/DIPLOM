package org.example.springboot.repository;

import java.util.UUID;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import org.example.springboot.object.ApplicationLease;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository

public interface ApplicationLeaseRepository extends JpaRepository<ApplicationLease, UUID> {
    Optional<ApplicationLease> findByName(String name);
}
