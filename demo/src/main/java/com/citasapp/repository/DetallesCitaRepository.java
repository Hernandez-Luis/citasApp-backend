package com.citasapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.citasapp.model.DetalleCita;

public interface DetallesCitaRepository extends MongoRepository<DetalleCita, String>{
    
}
