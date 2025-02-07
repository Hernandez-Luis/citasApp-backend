package com.citasapp.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citasapp.model.NoSQL.Prioridad;
import com.citasapp.repository.PrioridadRepository;
import com.citasapp.service.IPrioridadService;

@Service
public class PrioridadServiceJPA implements IPrioridadService {

    @Autowired
    private PrioridadRepository prioridadRepository;

    @Override
    public Iterable<Prioridad> findAll() {
        return prioridadRepository.findAll();
    }

    @Override
    public Optional<Prioridad> findById(String id) {
        return prioridadRepository.findById(id); // Cambié Long a String
    }

    @Override
    public Prioridad save(Prioridad prioridad) {
        return prioridadRepository.save(prioridad);
    }

    @Override
    public Optional<Prioridad> update(Prioridad prioridad, String id) {  // Cambié Long a String
        Optional<Prioridad> prioridadOptional = this.findById(id);
        if(prioridadOptional.isPresent()){
            Prioridad prioridadBD = prioridadOptional.get();
            prioridadBD.setPrioridad(prioridad.getPrioridad());
            return Optional.of(prioridadRepository.save(prioridadBD));
        }
        return Optional.empty();
    }

    @Override
    public void remove(String id) {  // Cambié Long a String
        prioridadRepository.deleteById(id);
    }
}
