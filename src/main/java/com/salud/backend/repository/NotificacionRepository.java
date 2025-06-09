package com.salud.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salud.backend.model.Notificacion;

public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {
}
