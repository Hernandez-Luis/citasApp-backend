package com.citasapp.service;

import java.util.List;
import java.util.Optional;

import com.citasapp.model.NoSQL.Prioridad;

public interface IPrioridadService {
    Iterable<Prioridad> findAll();
    Optional<Prioridad> findById(String id);
    Prioridad save (Prioridad prioridad);
    Optional<Prioridad> update(Prioridad prioridad, String id);
    void remove (String id);
}
