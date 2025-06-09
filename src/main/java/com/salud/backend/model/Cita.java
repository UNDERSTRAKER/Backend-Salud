package com.salud.backend.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Cita")
public class Cita implements Serializable {

    @Id
    private Long id_cita;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    private String hora;

    @Column(length = 500)
    private String motivo;

    @Column(length = 20)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_profesional", nullable = false)
    private ProfesionalSalud profesional;

    // Getters y Setters

    public Long getId_cita() { return id_cita; }
    public void setId_cita(Long id_cita) { this.id_cita = id_cita; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public String getHora() { return hora; }
    public void setHora(String hora) { this.hora = hora; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }

    public ProfesionalSalud getProfesional() { return profesional; }
    public void setProfesional(ProfesionalSalud profesional) { this.profesional = profesional; }
}
