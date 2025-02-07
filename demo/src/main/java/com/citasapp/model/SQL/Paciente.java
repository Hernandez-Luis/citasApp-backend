package com.citasapp.model.SQL;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "Pacientes")
@ToString
public class Paciente {
    
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_paciente;

    @Column(name = "nombrePaciente", nullable = false)
    private String nombrePaciente;

    @Column(name = "edad", nullable = false)
    private int edad;

    @Column(name = "peso", nullable = true)
    private double peso;

    @Column(name = "informacionAdicional", nullable = true)
    private String informacionAdicional;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cita> citas;

}
