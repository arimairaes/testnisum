package com.evaluacion.usuarioapirest.repositories;

import com.evaluacion.usuarioapirest.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<Users, UUID> {

    Optional<Users> findByEmail(String email);
}