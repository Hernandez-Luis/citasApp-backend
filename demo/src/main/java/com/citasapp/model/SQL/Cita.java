package com.citasapp.model.SQL;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.citasapp.model.NoSQL.Doctores;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
    private String fechaCita;

    @Column(name = "hora", nullable = true)
    private String hora;

    @Column(nullable = true, length = 500)
    private String motivo;

    @ManyToOne
    @JoinColumn(name = "id_clinica", nullable = false)
    private Clinica clinica;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;


    @Column(name = "id_doctor_mongo", nullable = true)
    private String idDoctorMongo;

}
