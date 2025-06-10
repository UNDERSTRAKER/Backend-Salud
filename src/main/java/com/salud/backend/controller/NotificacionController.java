package com.salud.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salud.backend.model.Notificacion;
import com.salud.backend.repository.NotificacionRepository;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {

    @Autowired
    private NotificacionRepository notificacionRepository;

    @GetMapping("/usuario/{id_usuario}")
    public List<Notificacion> obtenerPorUsuario(@PathVariable Long id_usuario) {
        return notificacionRepository.findByIdUsuario(id_usuario);
    }
}
