package com.salud.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salud.backend.model.ProfesionalSalud;
import com.salud.backend.repository.ProfesionalSaludRepository;

@RestController
@RequestMapping("/api/profesionales")
public class ProfesionalSaludController {

    private final ProfesionalSaludRepository profesionalSaludRepository;

    public ProfesionalSaludController(ProfesionalSaludRepository profesionalSaludRepository) {
        this.profesionalSaludRepository = profesionalSaludRepository;
    }

    @GetMapping
    public List<ProfesionalSalud> listarProfesionales() {
        return profesionalSaludRepository.findAll();
    }

    @PostMapping
    public ProfesionalSalud crearProfesional(@RequestBody ProfesionalSalud profesional) {
        return profesionalSaludRepository.save(profesional);
    }
}
