package com.salud.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salud.backend.model.Paciente;
import com.salud.backend.repository.PacienteRepository;

@CrossOrigin(origins = {
    "https://frontend-salud.vercel.app",
    "https://frontend-salud-p2yzzida8-felipe-padillas-projects-3e2d6501.vercel.app"
})

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    private final PacienteRepository pacienteRepository;

    public PacienteController(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @GetMapping
    public List<Paciente> listarPacientes() {
        return pacienteRepository.findAll();
    }

    @PostMapping
    public Paciente crearPaciente(@RequestBody Paciente paciente) {
        return pacienteRepository.save(paciente);
    }
}
