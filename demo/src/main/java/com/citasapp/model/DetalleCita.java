package com.citasapp.model;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

import org.springframework.data.annotation.Id;

@Data
@Document
public class DetalleCita {
    @Id
    private String id;
    private String nota;
    private String recomendacion;

}
