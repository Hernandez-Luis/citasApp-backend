package com.citasapp.model;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document
public class DetalleCita {
    @Id
    private String id;
    private String nota;
    private String recomendacion;

}
