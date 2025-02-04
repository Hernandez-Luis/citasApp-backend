package com.citasapp.controller;

import com.citasapp.model.DetalleCita;
import com.citasapp.service.IDetalleCitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/detalleCitas")
public class DetalleCitaController {

    @Autowired
    private IDetalleCitasService detalleCitaService;

    @GetMapping
    public List<DetalleCita> list() {
        return detalleCitaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDetalleCitaById(@PathVariable String id) {
        Optional<DetalleCita> detalleCitaOptional = detalleCitaService.findById(id);
        if(detalleCitaOptional.isPresent()){
            return ResponseEntity.ok(detalleCitaOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create (@Valid @RequestBody DetalleCita detalleCita, BindingResult result){
        if(result.hasErrors()){
            return validation(result);
        }
        DetalleCita detalleCitaCreated = detalleCitaService.save(detalleCita);
        return ResponseEntity.status(HttpStatus.CREATED).body(detalleCitaCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update (@Valid @RequestBody DetalleCita detalleCita, BindingResult result, @PathVariable String id){
        if(result.hasErrors()){
            return validation(result);
        }
        Optional<DetalleCita> detalleCitaOptional = detalleCitaService.update(detalleCita, id);
        if(detalleCitaOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(detalleCitaOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove (@PathVariable String id){
        Optional<DetalleCita> detalleCitaOptional = detalleCitaService.findById(id);
        if(detalleCitaOptional.isPresent()){
            detalleCitaService.remove(id);
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

