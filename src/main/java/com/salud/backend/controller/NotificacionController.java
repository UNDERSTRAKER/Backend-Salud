package com.salud.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salud.backend.model.Notificacion;
import com.salud.backend.repository.NotificacionRepository;

@CrossOrigin(origins = {
    "https://frontend-salud.vercel.app",
    "https://frontend-salud-p2yzzida8-felipe-padillas-projects-3e2d6501.vercel.app"
})
@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {

    private final NotificacionRepository notificacionRepository;

    public NotificacionController(NotificacionRepository notificacionRepository) {
        this.notificacionRepository = notificacionRepository;
    }

    @GetMapping
    public List<Notificacion> listarTodas() {
        return notificacionRepository.findAll();
    }

    // Este otro es el filtrado por usuario
    @GetMapping("/usuario/{id_usuario}")
    public List<Notificacion> obtenerPorUsuario(@PathVariable Long id_usuario) {
        return notificacionRepository.buscarPorIdUsuario(id_usuario);
    }
}
