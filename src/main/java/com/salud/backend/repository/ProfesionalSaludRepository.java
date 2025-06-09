package com.salud.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salud.backend.model.ProfesionalSalud;

public interface ProfesionalSaludRepository extends JpaRepository<ProfesionalSalud, Long> {
}
