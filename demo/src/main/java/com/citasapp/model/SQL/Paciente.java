package com.citasapp.model.SQL;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@Table(name = "pacientes")
@ToString
public class Paciente {
    
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_paciente;

    @Column(name = "nombre_paciente", nullable = false)
    private String nombrePaciente;

    @Column(name = "edad", nullable = false)
    private int edad;

    @Column(name = "peso", nullable = true)
    private double peso;

    @Column(name = "informacion_adicional", nullable = true)
    private String informacionAdicional;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Cita> citas;

}
