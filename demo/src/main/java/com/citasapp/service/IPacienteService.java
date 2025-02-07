package com.citasapp.service;

import java.util.List;
import java.util.Optional;

import com.citasapp.model.SQL.Paciente;


public interface  IPacienteService {
    List<Paciente> findAll();
    Optional<Paciente> findById(Long id);
    Paciente save (Paciente paciente);
    Optional<Paciente> update(Paciente paciente, Long id);
    void remove (Long id);
}
