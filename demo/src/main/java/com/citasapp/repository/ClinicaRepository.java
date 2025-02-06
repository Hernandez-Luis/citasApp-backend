package com.citasapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.citasapp.model.SQL.Clinica;

@Repository
public interface ClinicaRepository extends CrudRepository<Clinica,Long> {

    
}
