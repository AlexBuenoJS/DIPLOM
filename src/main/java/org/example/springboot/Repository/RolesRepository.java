package org.example.springboot.repository;

import org.springframework.stereotype.Repository;
import java.util.UUID;
import org.example.springboot.object.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository

public interface RolesRepository extends JpaRepository<Roles,UUID>{
}
