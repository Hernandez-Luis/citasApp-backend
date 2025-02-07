package com.citasapp.service;

import java.util.List;
import java.util.Optional;

import com.citasapp.model.SQL.Prioridad;

public interface IPrioridadService {
    List<Prioridad> findAll();
    Optional<Prioridad> findById(Long id);
    Prioridad save (Prioridad prioridad);
    Optional<Prioridad> update(Prioridad prioridad, Long id);
    void remove (Long id);
}
