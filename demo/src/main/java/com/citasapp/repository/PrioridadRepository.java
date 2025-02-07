package com.citasapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.citasapp.model.NoSQL.Prioridad;

@Repository
public interface PrioridadRepository extends CrudRepository<Prioridad, String>{
    
}
