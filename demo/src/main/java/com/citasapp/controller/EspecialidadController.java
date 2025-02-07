package com.citasapp.controller;

import com.citasapp.model.NoSQL.Especialidad;
import com.citasapp.service.db.EspecialidadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadController {

    @Autowired
    private EspecialidadService especialidadService;

    // Crear nueva especialidad
    @PostMapping
    public ResponseEntity<Especialidad> createEspecialidad(@RequestBody Especialidad especialidad) {
        Especialidad savedEspecialidad = especialidadService.createEspecialidad(especialidad);
        return new ResponseEntity<>(savedEspecialidad, HttpStatus.CREATED);
    }

    // Obtener todas las especialidades
    @GetMapping
    public List<Especialidad> getAllEspecialidades() {
        return especialidadService.getAllEspecialidades();
    }

    // Obtener especialidad por ID
    @GetMapping("/{id}")
    public ResponseEntity<Especialidad> getEspecialidadById(@PathVariable String id) {
        Optional<Especialidad> especialidad = especialidadService.getEspecialidadById(id);
        return especialidad.map(ResponseEntity::ok)
                           .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Actualizar especialidad
    @PutMapping("/{id}")
    public ResponseEntity<Especialidad> updateEspecialidad(@PathVariable String id, @RequestBody Especialidad especialidad) {
        Especialidad updatedEspecialidad = especialidadService.updateEspecialidad(id, especialidad);
        return updatedEspecialidad != null
                ? new ResponseEntity<>(updatedEspecialidad, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Eliminar especialidad
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEspecialidad(@PathVariable String id) {
        especialidadService.deleteEspecialidad(id);
        return ResponseEntity.noContent().build();
    }
}
