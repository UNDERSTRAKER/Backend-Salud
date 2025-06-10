package com.salud.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salud.backend.model.Usuario;
import com.salud.backend.repository.UsuarioRepository;

@CrossOrigin(origins = {
    "https://frontend-salud.vercel.app",
    "https://frontend-salud-p2yzzida8-felipe-padillas-projects-3e2d6501.vercel.app"
})

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        // Obtener el próximo ID desde la secuencia en Oracle
        Long nuevoId = jdbcTemplate.queryForObject("SELECT USUARIO_SEQ.NEXTVAL FROM DUAL", Long.class);
        usuario.setId_usuario(nuevoId);
        return usuarioRepository.save(usuario);
    }
}
