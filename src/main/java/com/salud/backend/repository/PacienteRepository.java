package com.salud.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salud.backend.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
