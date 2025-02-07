package com.citasapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.citasapp.model.NoSQL.Especialidad;;

@Repository
public interface EspecialidadRepository extends MongoRepository<Especialidad, String> {
    // Puedes agregar métodos personalizados si es necesario
}