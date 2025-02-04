package com.citasapp.service;

import java.util.List;
import java.util.Optional;

import com.citasapp.model.Cita;

public interface ICitasService {
    List<Cita> findAll();
    Optional<Cita> findById(Long id);
    Cita save (Cita cita);
    Optional<Cita> update(Cita cita, Long id);
    void remove (Long id);
} 