package com.salud.backend.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PROFESIONALSALUD")
public class ProfesionalSalud implements Serializable {

    @Id
    private Long id_usuario; // Es también la PK, relacionada con Usuario

    @ManyToOne
    @JoinColumn(name = "id_especialidad", nullable = false)
    private Especialidad especialidad;

    @Column(name = "registro_profesional", nullable = false)
    private String registroProfesional;

    // Getters y setters

    public Long getId_usuario() { return id_usuario; }
    public void setId_usuario(Long id_usuario) { this.id_usuario = id_usuario; }

    public Especialidad getEspecialidad() { return especialidad; }
    public void setEspecialidad(Especialidad especialidad) { this.especialidad = especialidad; }

    public String getRegistroProfesional() { return registroProfesional; }
    public void setRegistroProfesional(String registroProfesional) { this.registroProfesional = registroProfesional; }
}
