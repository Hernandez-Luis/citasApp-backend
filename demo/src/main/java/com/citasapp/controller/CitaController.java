package com.citasapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citasapp.model.Cita;
import com.citasapp.service.CitaService;

@RestController
@RequestMapping("citas")

public class CitaController {
    @Autowired
    private CitaService citaService;

    @GetMapping
    public List<Cita> getAllCitas() {
        return citaService.getAllCitas();
    }
    @PostMapping
    public ResponseEntity<Cita> createCita(@RequestBody Cita cita) {
        Cita createdCita = citaService.createCita(cita);
        return new ResponseEntity<>(createdCita, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Cita> getCitaById(@PathVariable Long id) {
        Cita cita = citaService.getCitaById(id);
        return cita != null ? new ResponseEntity<>(cita, HttpStatus.OK) : ResponseEntity.notFound().build();
    }
}
