package com.citasapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citasapp.model.DetalleCita;
import com.citasapp.service.CitaService;

@RestController
@RequestMapping("/detalleCitas")
public class DetalleCitaController {
    @Autowired
    private CitaService citaService;

    @PostMapping
    public ResponseEntity<DetalleCita> createDetalleCita(@RequestBody DetalleCita detalleCita) {
        DetalleCita createdDetalle = citaService.createDetalleCita(detalleCita);
        return new ResponseEntity<>(createdDetalle, HttpStatus.CREATED);
    }
}
