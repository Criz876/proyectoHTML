package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Polo;

public interface PoloRepository extends JpaRepository<Polo, Integer> {
    @Query("SELECT p FROM Polo p WHERE p.correo_polo = :correo AND p.contrasena_polo = :contrasena")
    Optional<Polo> findByCorreo_poloAndContrasena_polo(
        @Param("correo") String correo, 
        @Param("contrasena") String contrasena
    );
}
