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

import com.citasapp.model.SQL.Prioridad;
import com.citasapp.service.IPrioridadService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/prioridades")
public class PrioridadController {
    @Autowired
    private IPrioridadService iPrioridadService;

    @GetMapping
    public List<Prioridad> list() {
        return iPrioridadService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCitaById(@PathVariable Long id) {
        Optional<Prioridad> prioridadOptional = iPrioridadService.findById(id);
        if(prioridadOptional.isPresent()){
            return ResponseEntity.ok(prioridadOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

     @PostMapping
    public ResponseEntity<?> create (@Valid @RequestBody Prioridad clinica, BindingResult result){
        if(result.hasErrors()){
            return validation(result);
        }
        Prioridad prioridadCreated = iPrioridadService.save(clinica);
        return ResponseEntity.status(HttpStatus.CREATED).body(prioridadCreated);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update (@Valid @RequestBody Prioridad prioridad, BindingResult result, @PathVariable Long id){
        if(result.hasErrors()){
            return validation(result);
        }
        Optional<Prioridad> prioridadOptional = iPrioridadService.update(prioridad,id);
        if(prioridadOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(prioridadOptional.get());
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove (@PathVariable Long id){
        Optional<Prioridad> prioridadOptional = iPrioridadService.findById(id);
        if(prioridadOptional.isPresent()){
            iPrioridadService.remove(id);
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
