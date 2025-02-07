package com.citasapp.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.citasapp.model.SQL.Clinica;
import com.citasapp.repository.ClinicaRepository;
import com.citasapp.service.IClinicaService;

@Service
public class ClinicaServiceJPA implements IClinicaService {

    @Autowired
    private ClinicaRepository clinicaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Clinica> findAll() {
        return (List<Clinica>) clinicaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Clinica> findById(Long id) {
        return clinicaRepository.findById(id);
    }

    @Override
    @Transactional
    public Clinica save(Clinica clinica) {
        return clinicaRepository.save(clinica);
    }

    @Override
    @Transactional
    public Optional<Clinica> update(Clinica clinica, Long id) {
        Optional<Clinica> clinicaOptional = this.findById(id);
        Clinica clinicaResult = null;
        if(clinicaOptional.isPresent()){
            Clinica clinicaBD = clinicaOptional.orElseThrow();
            clinicaBD.setNombreClinica(clinica.getNombreClinica());
            clinicaBD.setUbicacion(clinica.getUbicacion());
            clinicaResult = this.save(clinicaBD);
        }
        return Optional.ofNullable(clinicaResult);
    }

    @Override
    public void remove(Long id) {
        clinicaRepository.deleteById(id);
    }
}
