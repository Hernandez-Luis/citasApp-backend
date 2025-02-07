package com.citasapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.citasapp.model.SQL.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    
}
