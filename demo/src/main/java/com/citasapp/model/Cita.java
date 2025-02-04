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

    @Column(nullable = false)
    private String condicion;

    @Column(name = "nombre_paciente", nullable = true)
    private String nombrePaciente;

    @Column(nullable = true)
    private Integer edad;  // Cambiado a Integer para representar la edad correctamente

    @Column(nullable = true, length = 500)
    private String motivo;
}
