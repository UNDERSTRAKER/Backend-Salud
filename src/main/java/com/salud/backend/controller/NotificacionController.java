package com.salud.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salud.backend.model.Notificacion;
import com.salud.backend.repository.NotificacionRepository;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {

    private final NotificacionRepository notificacionRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public NotificacionController(NotificacionRepository notificacionRepository) {
        this.notificacionRepository = notificacionRepository;
    }

    @GetMapping
    public List<Notificacion> listarNotificaciones() {
        return notificacionRepository.findAll();
    }

    @PostMapping
    public Notificacion crearNotificacion(@RequestBody Notificacion notificacion) {
        // Obtener el próximo ID desde la secuencia de Oracle
        Long nuevoId = jdbcTemplate.queryForObject("SELECT NOTIFICACION_SEQ.NEXTVAL FROM DUAL", Long.class);
        notificacion.setId_notificacion(nuevoId);
        return notificacionRepository.save(notificacion);
    }
}
