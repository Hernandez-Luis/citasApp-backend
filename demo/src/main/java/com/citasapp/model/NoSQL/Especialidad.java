package com.citasapp.model.NoSQL;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.*;

@Data
@Document(collection = "especialidades")
@NoArgsConstructor
@AllArgsConstructor
public class Especialidad {
    @Id
    private String id;
    
    private String nombre_especialidad;

    private String matricula;

    private String experiencia;
}
