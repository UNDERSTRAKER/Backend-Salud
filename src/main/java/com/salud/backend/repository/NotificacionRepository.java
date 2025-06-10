package com.salud.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salud.backend.model.Notificacion;

public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {
    List<Notificacion> findByIdUsuario(Long id_usuario);
}
