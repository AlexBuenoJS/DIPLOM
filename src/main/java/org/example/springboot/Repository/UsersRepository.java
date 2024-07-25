package org.example.springboot.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.UUID;
import java.util.Optional;
import org.example.springboot.object.Users;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository

public interface UsersRepository extends JpaRepository<Users,UUID> {
    @Query("FROM Users u JOIN FETCH u.roles WHERE u.username = :username")
    Optional<Users>findByUsername(String username);
}
