package com.salud.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salud.backend.model.Cita;
import com.salud.backend.repository.CitaRepository;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    private final CitaRepository citaRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public CitaController(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    @GetMapping
    public List<Cita> listarCitas() {
        return citaRepository.findAll();
    }

    @PostMapping
    public Cita crearCita(@RequestBody Cita cita) {
        // Obtener el próximo ID desde la secuencia de Oracle
        Long nuevoId = jdbcTemplate.queryForObject("SELECT CITA_SEQ.NEXTVAL FROM DUAL", Long.class);
        cita.setId_cita(nuevoId);
        return citaRepository.save(cita);
    }
}
