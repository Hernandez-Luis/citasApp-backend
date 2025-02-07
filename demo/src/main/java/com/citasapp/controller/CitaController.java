package com.citasapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.citasapp.model.SQL.Cita;
import com.citasapp.service.ICitasService;
import jakarta.validation.Valid;



@RestController
@RequestMapping("/citas")
public class CitaController {
    @Autowired
    private ICitasService iCitasService;

    @GetMapping
    public List<Cita> list() {
        return iCitasService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getCitaById(@PathVariable Long id) {
        Optional<Cita> citaOptional = iCitasService.findById(id);
        if(citaOptional.isPresent()){
            return ResponseEntity.ok(citaOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create (@Valid @RequestBody Cita cita, BindingResult result){
        if(result.hasErrors()){
            return validation(result);
        }
        Cita citaCreated = iCitasService.save(cita);
        return ResponseEntity.status(HttpStatus.CREATED).body(citaCreated);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> update (@Valid @RequestBody Cita cita, BindingResult result, @PathVariable Long id){
        if(result.hasErrors()){
            return validation(result);
        }
        Optional<Cita> citaOptional = iCitasService.update(cita,id);
        if(citaOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(citaOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove (@PathVariable Long id){
        Optional<Cita> citaOptional = iCitasService.findById(id);
        if(citaOptional.isPresent()){
            iCitasService.remove(id);
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
