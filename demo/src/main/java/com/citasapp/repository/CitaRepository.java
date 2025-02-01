package com.citasapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citasapp.model.Cita;

public interface CitaRepository extends JpaRepository<Cita, Long>{

    
}
