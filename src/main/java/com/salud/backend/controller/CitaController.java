package com.salud.backend.controller;

import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salud.backend.model.Cita;
import com.salud.backend.model.Notificacion;
import com.salud.backend.repository.CitaRepository;
import com.salud.backend.repository.NotificacionRepository;
import com.salud.backend.repository.PacienteRepository;
import com.salud.backend.repository.ProfesionalSaludRepository;

@CrossOrigin(origins = {
    "https://frontend-salud.vercel.app",
    "https://frontend-salud-p2yzzida8-felipe-padillas-projects-3e2d6501.vercel.app"
})
@RestController
@RequestMapping("/api/citas")
public class CitaController {

    private final CitaRepository citaRepository;
    private final NotificacionRepository notificacionRepository;
    private final PacienteRepository pacienteRepository;
    private final ProfesionalSaludRepository profesionalSaludRepository;

    public CitaController(
        CitaRepository citaRepository,
        NotificacionRepository notificacionRepository,
        PacienteRepository pacienteRepository,
        ProfesionalSaludRepository profesionalSaludRepository
    ) {
        this.citaRepository = citaRepository;
        this.notificacionRepository = notificacionRepository;
        this.pacienteRepository = pacienteRepository;
        this.profesionalSaludRepository = profesionalSaludRepository;
    }

    @GetMapping
    public List<Cita> listarCitas() {
        return citaRepository.findAll();
    }

    @PostMapping
    public Cita crearCita(@RequestBody Cita cita) {
        // Buscar entidades completas por ID antes de guardar
        if (cita.getPaciente() != null && cita.getPaciente().getId_usuario() != null) {
            cita.setPaciente(pacienteRepository.findById(cita.getPaciente().getId_usuario()).orElse(null));
        }
        if (cita.getProfesional() != null && cita.getProfesional().getId_usuario() != null) {
            cita.setProfesional(profesionalSaludRepository.findById(cita.getProfesional().getId_usuario()).orElse(null));
        }

        Cita nuevaCita = citaRepository.save(cita);

        // Crear notificación aleatoria
        String estado = new Random().nextBoolean() ? "confirmada" : "pendiente";
        Notificacion notificacion = new Notificacion();
        notificacion.setMensaje("Su cita fue registrada y está " + estado + ".");
        notificacion.setEstado("no_leida");
        notificacion.setUsuario(nuevaCita.getPaciente().getUsuario());

        notificacionRepository.save(notificacion);

        return nuevaCita;
    }
}