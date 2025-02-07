package com.citasapp.model.NoSQL;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "doctores")
@NoArgsConstructor
@AllArgsConstructor
public class Doctores {
    @Id
    private String id;

    private String nombre_doctor;

    private String telefono;

    private String correo;


    @DBRef
    private Especialidad especialidad;
}
