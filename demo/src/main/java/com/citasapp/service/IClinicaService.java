package com.citasapp.service;

import java.util.List;
import java.util.Optional;

import com.citasapp.model.SQL.Clinica;

public interface IClinicaService {
    List<Clinica> findAll();
    Optional<Clinica> findById(Long id);
    Clinica save (Clinica clinica);
    Optional<Clinica> update(Clinica clinica, Long id);
    void remove (Long id);
}
