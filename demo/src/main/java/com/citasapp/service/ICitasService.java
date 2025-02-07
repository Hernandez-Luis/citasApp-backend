package com.citasapp.service;

import java.util.List;
import java.util.Optional;

import com.citasapp.DTO.CitaDTO;
import com.citasapp.model.SQL.Cita;

public interface ICitasService {
    List<Cita> findAll();
    Optional<CitaDTO> findByIdDto(Long id);
    //Optional<Cita> findById(Long id);
    Cita save (Cita cita);
    Optional<Cita> update(Cita cita, Long id);
    void remove (Long id);
} 