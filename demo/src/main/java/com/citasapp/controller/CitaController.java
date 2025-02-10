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

import com.citasapp.DTO.CitaDTO;
import com.citasapp.model.NoSQL.Doctores;
import com.citasapp.model.SQL.Cita;
import com.citasapp.model.SQL.Clinica;
import com.citasapp.model.SQL.Paciente;
import com.citasapp.repository.CitaRepository;
import com.citasapp.repository.ClinicaRepository;
import com.citasapp.repository.PacienteRepository;
import com.citasapp.service.ICitasService;
import jakarta.validation.Valid;



@RestController
@RequestMapping("/citas")
public class CitaController {
    @Autowired
    private ICitasService iCitasService;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ClinicaRepository clinicaRepository;

    @Autowired
    private CitaRepository citaRepository;

    @GetMapping
    public List<Cita> list() {
        return iCitasService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getCitaById(@PathVariable Long id) {
        Optional<CitaDTO> citaOptional = iCitasService.findByIdDto(id);
        if(citaOptional.isPresent()){
            return ResponseEntity.ok(citaOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> crearCita(@RequestBody Cita cita) {
        DoctoresController doctoresController;
        Optional<Paciente> paciente = pacienteRepository.findById(cita.getPaciente().getId_paciente());
        Optional<Clinica> clinica = clinicaRepository.findById(cita.getClinica().getId_clinica());

        if (paciente.isPresent() && clinica.isPresent()) {
            cita.setPaciente(paciente.get());
            cita.setClinica(clinica.get());
            Cita nuevaCita = citaRepository.save(cita);
            return ResponseEntity.ok(nuevaCita);
        } else {
            return ResponseEntity.badRequest().body("Paciente o Clínica no encontrados");
        }
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
        Optional<CitaDTO> citaOptional = iCitasService.findByIdDto(id);
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
