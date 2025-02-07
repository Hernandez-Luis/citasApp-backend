package com.citasapp.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.citasapp.model.SQL.Paciente;
import com.citasapp.repository.PacienteRepository;
import com.citasapp.service.IPacienteService;

@Service
public class PacienteServiceJPA implements IPacienteService{
    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    @Transactional(readOnly =  true)
    public List<Paciente> findAll() {
        return (List<Paciente>) pacienteRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Paciente> findById(Long id) {
        return pacienteRepository.findById(id); 
    }

    @Override
    @Transactional
    public Paciente save(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    @Transactional
    public Optional<Paciente> update(Paciente paciente, Long id) {
        Optional<Paciente> pacienteOptional = this.findById(id);
        Paciente pacienteResult = null;
        if(pacienteOptional.isPresent()){
            Paciente pacienteBD = pacienteOptional.orElseThrow();
            pacienteBD.setNombrePaciente(paciente.getNombrePaciente());
            pacienteBD.setEdad(paciente.getEdad());
            pacienteBD.setPeso(paciente.getPeso());
            pacienteBD.setInformacionAdicional(paciente.getInformacionAdicional());
            pacienteResult = this.save(pacienteBD);
        } 
        return Optional.ofNullable(pacienteResult);
    }
    @Override
    @Transactional
    public void remove(Long id) {
        pacienteRepository.deleteById(id);
    }
}

