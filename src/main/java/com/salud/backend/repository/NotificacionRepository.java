package com.salud.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.salud.backend.model.Notificacion;

public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {
    @Query("SELECT n FROM Notificacion n WHERE n.usuario.id_usuario = :idUsuario")
    List<Notificacion> buscarPorIdUsuario(@Param("idUsuario") Long idUsuario);
}
