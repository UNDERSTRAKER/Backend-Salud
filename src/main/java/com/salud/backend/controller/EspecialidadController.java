package com.salud.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salud.backend.model.Especialidad;
import com.salud.backend.repository.EspecialidadRepository;

@CrossOrigin(origins = {
    "https://frontend-salud.vercel.app",
    "https://frontend-salud-p2yzzida8-felipe-padillas-projects-3e2d6501.vercel.app"
})

@RestController
@RequestMapping("/api/especialidades")
public class EspecialidadController {

    private final EspecialidadRepository especialidadRepository;

    public EspecialidadController(EspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }

    @GetMapping
    public List<Especialidad> listarEspecialidades() {
        return especialidadRepository.findAll();
    }

}
