package com.citasapp.model.SQL;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "pacientes")
@ToString
public class Paciente {
    
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_paciente", nullable = false)
    private String nombrePaciente;

    @Column(name = "edad", nullable = false)
    private int edad;

    @Column(name = "peso", nullable = true)
    private double peso;

    @Column(name = "informacion_adicional", nullable = true)
    private String informacionAdicional;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cita> citas;

}
