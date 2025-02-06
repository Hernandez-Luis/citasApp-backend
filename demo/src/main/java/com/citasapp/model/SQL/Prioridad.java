package com.citasapp.model.SQL;



import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "prioridades")
@ToString
public class Prioridad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_prioridad;

    @Column(name = "prioridad", nullable = true)
    private String prioridad;

    @OneToMany(mappedBy = "prioridad", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cita> citas;
}
