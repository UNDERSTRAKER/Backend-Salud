package com.salud.backend.controller;

import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salud.backend.model.Cita;
import com.salud.backend.model.Notificacion;
import com.salud.backend.repository.CitaRepository;
import com.salud.backend.repository.NotificacionRepository;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    private final CitaRepository citaRepository;
    private final NotificacionRepository notificacionRepository;

    public CitaController(CitaRepository citaRepository, NotificacionRepository notificacionRepository) {
        this.citaRepository = citaRepository;
        this.notificacionRepository = notificacionRepository;
    }

    @GetMapping
    public List<Cita> listarCitas() {
        return citaRepository.findAll();
    }

    @PostMapping
    public Cita crearCita(@RequestBody Cita cita) {
        // Guardar la cita
        Cita nuevaCita = citaRepository.save(cita);

        // Crear notificación aleatoria
        String estado = new Random().nextBoolean() ? "confirmada" : "pendiente";
        Notificacion notificacion = new Notificacion();
        notificacion.setMensaje("Su cita fue registrada y está " + estado + ".");
        notificacion.setEstado("no_leida");
        notificacion.setUsuario(cita.getPaciente().getUsuario());

        notificacionRepository.save(notificacion);

        return nuevaCita;
    }
}
