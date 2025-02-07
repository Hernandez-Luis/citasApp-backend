package com.citasapp.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.citasapp.model.SQL.Prioridad;
import com.citasapp.repository.PrioridadRepository;
import com.citasapp.service.IPrioridadService;


@Service
public class PrioridadServiceJPA implements IPrioridadService {

    @Autowired
    private PrioridadRepository prioridadRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Prioridad> findAll() {
        return (List<Prioridad>) prioridadRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Prioridad> findById(Long id) {
        return prioridadRepository.findById(id); 
    }

    @Override
    @Transactional
    public Prioridad save(Prioridad prioridad) {
        return prioridadRepository.save(prioridad);
    }

    @Override
    @Transactional
    public Optional<Prioridad> update(Prioridad prioridad, Long id) {
        Optional<Prioridad> prioridadOptional = this.findById(id);
        Prioridad prioridadResult = null;
        if(prioridadOptional.isPresent()){
            Prioridad prioridadBD = prioridadOptional.orElseThrow();
            prioridadBD.setPrioridad(prioridad.getPrioridad());
            prioridadResult= this.save(prioridadBD);
        } 
        return Optional.ofNullable(prioridadResult);
    }

    @Override
    public void remove(Long id) {
        prioridadRepository.deleteById(id);
    }
    
}
