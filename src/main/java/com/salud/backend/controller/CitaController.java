package com.salud.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private CitaRepository citaRepository;

    @Autowired
    private NotificacionRepository notificacionRepository; // AQUÍ VA

    @GetMapping
    public List<Cita> listarCitas() {
        return citaRepository.findAll();
    }

    @PostMapping
    public Cita crearCita(@RequestBody Cita cita) {
        Cita nuevaCita = citaRepository.save(cita);

        // Crear notificación
        String estado = Math.random() < 0.5 ? "pendiente" : "confirmada";
        String mensaje = "Tu cita para el día " + cita.getFecha() + " a las " + cita.getHora() +
                         " ha sido registrada con estado: " + estado + ".";

        Notificacion notificacion = new Notificacion();
        notificacion.setId_usuario(cita.getPaciente().getId_usuario());
        notificacion.setMensaje(mensaje);
        notificacion.setEstado("no_leida");

        notificacionRepository.save(notificacion);

        return nuevaCita;
    }
}
