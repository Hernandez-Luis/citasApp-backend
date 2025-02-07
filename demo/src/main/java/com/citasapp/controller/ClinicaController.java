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

import com.citasapp.model.SQL.Clinica;
import com.citasapp.service.IClinicaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/clinicas")
public class ClinicaController {
    @Autowired
    private IClinicaService iClinicaService;

    @GetMapping
    public List<Clinica> list(){
        return iClinicaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClinicaById(@PathVariable Long id){
        Optional <Clinica> clinicaOptional = iClinicaService.findById(id);
        if(clinicaOptional.isPresent()){
            return ResponseEntity.ok(clinicaOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create (@Valid @RequestBody Clinica clinica, BindingResult result){
        if(result.hasErrors()){
            return validation(result);
        }
        Clinica clinicaCreated = iClinicaService.save(clinica);
        return ResponseEntity.status(HttpStatus.CREATED).body(clinicaCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update (@Valid @RequestBody Clinica clinica, BindingResult result, @PathVariable Long id){
        if(result.hasErrors()){
            return validation(result);
        }
        Optional<Clinica> clinicaOptional = iClinicaService.update(clinica,id);
        if(clinicaOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(clinicaOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove (@PathVariable Long id){
        Optional<Clinica> clinicaOptional = iClinicaService.findById(id);
        if(clinicaOptional.isPresent()){
            iClinicaService.remove(id);
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
