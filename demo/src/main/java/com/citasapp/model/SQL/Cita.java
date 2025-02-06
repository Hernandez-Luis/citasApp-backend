package com.citasapp.model.SQL;

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
    private Long id_cita;

    @Column(name = "nombre_medico", nullable = true)
    private String nombreMedico;

    @Column(name = "fecha_cita", nullable = true)
    private LocalDateTime fechaCita;

    @ManyToOne
    @JoinColumn(name = "id_clinica", nullable = false)
    private Clinica clinica;

    @ManyToOne
    @JoinColumn(name = "id_prioridad", nullable = false)
    private Prioridad prioridad;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;


    @Column(nullable = true, length = 500)
    private String motivo;
}
