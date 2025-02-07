package com.citasapp.model.NoSQL;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.*;

@Data
@Document(collection = "prioridades")
@AllArgsConstructor
@NoArgsConstructor
public class Prioridad {

    @Id
    private String id_prioridad;

    private String prioridad;
}
