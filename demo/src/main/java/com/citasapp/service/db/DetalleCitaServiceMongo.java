package com.citasapp.service.db;

import com.citasapp.model.DetalleCita;
import com.citasapp.repository.DetallesCitaRepository;
import com.citasapp.service.IDetalleCitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleCitaServiceMongo implements IDetalleCitasService {

    @Autowired
    private DetallesCitaRepository detalleCitaRepository;

    @Override
    public List<DetalleCita> findAll() {
        return detalleCitaRepository.findAll();
    }

    @Override
    public Optional<DetalleCita> findById(String id) {
        return detalleCitaRepository.findById(id);
    }

    @Override
    public DetalleCita save(DetalleCita detalleCita) {
        return detalleCitaRepository.save(detalleCita);
    }

    @Override
    public Optional<DetalleCita> update(DetalleCita detalleCita, String id) {
        if (detalleCitaRepository.existsById(id)) {
            detalleCita.setId(id);
            return Optional.of(detalleCitaRepository.save(detalleCita));
        }
        return Optional.empty();
    }

    @Override
    public void remove(String id) {
        detalleCitaRepository.deleteById(id);
    }
}

