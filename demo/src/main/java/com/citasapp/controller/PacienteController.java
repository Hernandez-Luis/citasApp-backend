package com.citasapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citasapp.model.SQL.Paciente;
import com.citasapp.service.IPacienteService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/pacientes")
public class PacienteController {
     @Autowired
    private IPacienteService iPacienteService;

    @GetMapping
    public List<Paciente> list() {
        return iPacienteService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getCitaById(@PathVariable Long id) {
        Optional<Paciente> pacienteOptional = iPacienteService.findById(id);
        if(pacienteOptional.isPresent()){
            return ResponseEntity.ok(pacienteOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create (@Valid @RequestBody Paciente paciente, BindingResult result){
        if(result.hasErrors()){
            return validation(result);
        }
        Paciente pacienteCreated = iPacienteService.save(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteCreated);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> update (@Valid @RequestBody Paciente paciente, BindingResult result, @PathVariable Long id){
        if(result.hasErrors()){
            return validation(result);
        }
        Optional<Paciente> pacienteOptional = iPacienteService.update(paciente,id);
        if(pacienteOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(pacienteOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove (@PathVariable Long id){
        Optional<Paciente> pacienteOptional = iPacienteService.findById(id);
        if(pacienteOptional.isPresent()){
            iPacienteService.remove(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().build();
    }

    private ResponseEntity<?> validation(BindingResult result){
        Map<String,String> errors = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), err.getDefaultMessage());
        }); 
        return ResponseEntity.badRequest().body(errors);
    }
}
