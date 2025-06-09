package com.salud.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salud.backend.model.Especialidad;

public interface EspecialidadRepository extends JpaRepository<Especialidad, Long> {
}
