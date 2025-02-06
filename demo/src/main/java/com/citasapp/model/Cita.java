package com.citasapp.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "citas")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_medico", nullable = true)
    private String nombreMedico;

    @Column(name = "fecha_cita", nullable = true)
    private LocalDateTime fechaCita;

    //Clinica id

    @Column(nullable = false)
    private String condicion; // se llamara prioridad y ssera otra tabla

    @Column(name = "nombre_paciente", nullable = true)
    private String nombrePaciente; // crear modelo de paciente y meter el id aqui

    @Column(nullable = true)
    private Integer edad;  // quitar y meter en modelo de paciebt

    @Column(nullable = true, length = 500)
    private String motivo; // se va para detalle cita
}
