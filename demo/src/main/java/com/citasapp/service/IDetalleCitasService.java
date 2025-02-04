package com.citasapp.service;

import com.citasapp.model.DetalleCita;

import java.util.List;
import java.util.Optional;

public interface IDetalleCitasService {
    List<DetalleCita> findAll();
    Optional<DetalleCita> findById(String id);
    DetalleCita save(DetalleCita detalleCita);
    Optional<DetalleCita> update(DetalleCita detalleCita, String id);
    void remove(String id);
}
