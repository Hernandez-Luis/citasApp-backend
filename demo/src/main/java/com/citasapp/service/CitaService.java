package com.citasapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citasapp.model.Cita;
import com.citasapp.model.DetalleCita;
import com.citasapp.repository.CitaRepository;
import com.citasapp.repository.DetallesCitaRepository;

@Service
public class CitaService {
    @Autowired
        private CitaRepository citaRepository;

        @Autowired
        private DetallesCitaRepository detalleCitaRepository;

        public List<Cita> getAllCitas() {
        return citaRepository.findAll();
        }
        public Cita createCita(Cita cita) {
            return citaRepository.save(cita);
        }
        public Cita getCitaById(Long id) {
            return citaRepository.findById(id).orElse(null);
        }
        public DetalleCita createDetalleCita(DetalleCita detalleCita) {
        return detalleCitaRepository.save(detalleCita);
        }
    
}
