package com.salud.backend.controller;

import com.salud.backend.model.Cita;
import com.salud.backend.model.Notificacion;
import com.salud.backend.repository.CitaRepository;
import com.salud.backend.repository.NotificacionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    @Autowired
    private CitaRepository citaRepository;

    @Autowired
    private NotificacionRepository notificacionRepository;

    @GetMapping
    public List<Cita> listarCitas() {
        return citaRepository.findAll();
    }

    @PostMapping
    public Cita crearCita(@RequestBody Cita cita) {
        // Guardar la cita en la base de datos
        Cita nuevaCita = citaRepository.save(cita);

        // Elegir aleatoriamente el estado
        String estadoAleatorio = Math.random() < 0.5 ? "pendiente" : "confirmada";
        nuevaCita.setEstado(estadoAleatorio);
        citaRepository.save(nuevaCita); // Actualizar el estado

        // Crear mensaje de notificación
        String mensaje = "Tu cita para el día " + nuevaCita.getFecha() +
                         " a las " + nuevaCita.getHora() +
                         " ha sido registrada con estado: " + estadoAleatorio + ".";

        // Crear la notificación
        Notificacion notificacion = new Notificacion();
        notificacion.setId_usuario(nuevaCita.getPaciente().getId_usuario());
        notificacion.setMensaje(mensaje);
        notificacion.setEstado("no_leida");

        notificacionRepository.save(notificacion);

        return nuevaCita;
    }
}
