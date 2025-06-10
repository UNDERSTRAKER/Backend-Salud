package com.salud.backend.controller;

import com.salud.backend.model.Cita;
import com.salud.backend.model.Notificacion;
import com.salud.backend.repository.CitaRepository;
import com.salud.backend.repository.NotificacionRepository;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.*;

import java.util.List;
=======
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salud.backend.model.Cita;
import com.salud.backend.model.Notificacion;
import com.salud.backend.repository.CitaRepository;
import com.salud.backend.repository.NotificacionRepository;
>>>>>>> c6d0b814c456ed367ca4413abc403d0e362398ae

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    @Autowired
    private CitaRepository citaRepository;

    @Autowired
<<<<<<< HEAD
    private NotificacionRepository notificacionRepository;
=======
    private NotificacionRepository notificacionRepository; // AQUÍ VA
>>>>>>> c6d0b814c456ed367ca4413abc403d0e362398ae

    @GetMapping
    public List<Cita> listarCitas() {
        return citaRepository.findAll();
    }

    @PostMapping
    public Cita crearCita(@RequestBody Cita cita) {
<<<<<<< HEAD
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
=======
        Cita nuevaCita = citaRepository.save(cita);

        // Crear notificación
        String estado = Math.random() < 0.5 ? "pendiente" : "confirmada";
        String mensaje = "Tu cita para el día " + cita.getFecha() + " a las " + cita.getHora() +
                         " ha sido registrada con estado: " + estado + ".";

        Notificacion notificacion = new Notificacion();
        notificacion.setId_usuario(cita.getPaciente().getId_usuario());
>>>>>>> c6d0b814c456ed367ca4413abc403d0e362398ae
        notificacion.setMensaje(mensaje);
        notificacion.setEstado("no_leida");

        notificacionRepository.save(notificacion);

        return nuevaCita;
    }
}
