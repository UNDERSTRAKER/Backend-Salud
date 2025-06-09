package com.salud.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salud.backend.model.Cita;

public interface CitaRepository extends JpaRepository<Cita, Long> {
}
