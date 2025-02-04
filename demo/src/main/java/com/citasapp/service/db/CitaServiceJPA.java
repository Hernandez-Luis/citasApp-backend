package com.citasapp.service.db;

import java.util.List;
import java.util.Optional;

import org.hibernate.validator.group.GroupSequenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.citasapp.model.Cita;
import com.citasapp.repository.CitaRepository;
import com.citasapp.service.ICitasService;

@Service
public class CitaServiceJPA implements ICitasService {

    @Autowired
    private CitaRepository citaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Cita> findAll() {
        return (List<Cita>) citaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Cita> findById(Long id) {
        return citaRepository.findById(id); 
    }

    @Override
    @Transactional
    public Cita save(Cita cita) {
        return citaRepository.save(cita);
    }

    @Override
    @Transactional
    public Optional<Cita> update(Cita cita, Long id) {
        Optional<Cita> citaOptional = this.findById(id);
        Cita citaResult = null;
        if(citaOptional.isPresent()){
            Cita citaBD = citaOptional.orElseThrow();
            citaBD.setNombreMedico(cita.getNombreMedico());
            citaBD.setFechaCita(cita.getFechaCita());
            citaBD.setCondicion(cita.getCondicion());
            citaBD.setNombrePaciente(cita.getNombrePaciente());
            citaBD.setEdad(cita.getEdad());
            citaBD.setMotivo(cita.getMotivo());
            citaResult = this.save(citaBD);
        } 
        return Optional.ofNullable(citaResult);
    }

    @Override
    public void remove(Long id) {
        citaRepository.deleteById(id);
    }
    
}
