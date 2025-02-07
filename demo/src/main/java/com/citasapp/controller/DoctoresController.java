package com.citasapp.controller;

import com.citasapp.model.NoSQL.Doctores;
import com.citasapp.model.NoSQL.Especialidad;
import com.citasapp.service.db.DoctoresService;
import com.citasapp.service.db.EspecialidadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctores")
public class DoctoresController {

    @Autowired
    private DoctoresService doctoresService;

    @Autowired
    private EspecialidadService especialidadService;

    // Crear un nuevo doctor
    // Crear un nuevo doctor con especialidad
    @PostMapping
    public ResponseEntity<Doctores> createDoctor(@RequestBody Doctores doctor) {
        // Obtener la especialidad por su ID
        Especialidad especialidad = especialidadService.getEspecialidadById(doctor.getEspecialidad().getId()).orElse(null);
        
        if (especialidad == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);  // Error si la especialidad no existe
        }

        doctor.setEspecialidad(especialidad);  // Asocia la especialidad al doctor
        Doctores savedDoctor = doctoresService.crearDoctor(doctor);  // Guardar el doctor
        return new ResponseEntity<>(savedDoctor, HttpStatus.CREATED);
    }

    // Obtener todos los doctores
    @GetMapping
    public ResponseEntity<List<Doctores>> obtenerTodosLosDoctores() {
        List<Doctores> doctores = doctoresService.obtenerTodosLosDoctores();
        return new ResponseEntity<>(doctores, HttpStatus.OK);
    }

    // Obtener un doctor por ID
    @GetMapping("/{id}")
    public ResponseEntity<Doctores> obtenerDoctorPorId(@PathVariable String id) {
        Optional<Doctores> doctor = doctoresService.obtenerDoctorPorId(id);
        return doctor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Actualizar un doctor
    @PutMapping("/{id}")
    public ResponseEntity<Doctores> actualizarDoctor(@PathVariable String id, @RequestBody Doctores doctor) {
        Doctores doctorActualizado = doctoresService.actualizarDoctor(id, doctor);
        return doctorActualizado != null ? ResponseEntity.ok(doctorActualizado) : ResponseEntity.notFound().build();
    }

    // Eliminar un doctor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDoctor(@PathVariable String id) {
        doctoresService.eliminarDoctor(id);
        return ResponseEntity.noContent().build();
    }
}
