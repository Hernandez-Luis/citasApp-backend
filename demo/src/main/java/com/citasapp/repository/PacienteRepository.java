package com.citasapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.citasapp.model.SQL.Paciente;

public interface PacienteRepository extends CrudRepository<Paciente, Long> {
    
}
