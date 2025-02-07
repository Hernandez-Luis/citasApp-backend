package com.citasapp.model.SQL;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "clinicas")
@ToString
public class Clinica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_clinica")
    private String nombreClinica;

    @Column(name = "ubicacion")
    private String ubicacion;

    @OneToMany(mappedBy = "clinica", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cita> citas;
}
