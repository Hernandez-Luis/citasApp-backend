package com.citasapp.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import jakarta.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "citas")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreMedico;
    private LocalDateTime fechaCita;
    private String condicion;
    private String nombrePaciente;
    private String edad;
    private String motivo;
}
