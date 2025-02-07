package com.citasapp.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.citasapp.DTO.CitaDTO;
import com.citasapp.model.NoSQL.Doctores;
import com.citasapp.model.SQL.Cita;
import com.citasapp.repository.CitaRepository;
import com.citasapp.repository.DoctorRepository;
import com.citasapp.service.ICitasService;

@Service
public class CitaServiceJPA implements ICitasService {

    @Autowired
    private DoctorRepository doctorRepository; // MongoDB Repository

    @Autowired
    private CitaRepository citaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Cita> findAll() {
        return (List<Cita>) citaRepository.findAll();
    }

    @Override
    public Cita createCita(Cita cita) {
        // Obtener el doctor por el ID de MongoDB
        Optional<Doctores> doctor = doctorRepository.findById(cita.getIdDoctorMongo());

        if (doctor.isPresent()) {
            // Si el doctor existe, se puede proceder con la cita
            cita.setNombreMedico(doctor.get().getNombre_doctor());
        } else {
            // Si no se encuentra el doctor, devolver error o manejar según la lógica
            throw new RuntimeException("Doctor no encontrado con el ID proporcionado");
        }

        // Guardar la cita en la base de datos SQL
        return citaRepository.save(cita);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<CitaDTO> findByIdDto(Long id) {
        Optional<Cita> citaOptional = citaRepository.findById(id);
        if (citaOptional.isPresent()) {
            Cita cita = citaOptional.get();

            // Validar si la cita tiene un ID de doctor antes de buscar en MongoDB
            Doctores doctor = null;
            if (cita.getIdDoctorMongo() != null) {
                doctor = doctorRepository.findById(cita.getIdDoctorMongo()).orElse(null);
            }

            return Optional.of(new CitaDTO(cita, doctor));
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<Cita> update(Cita cita, Long id) {
        return citaRepository.findById(id).map(citaBD -> {
            citaBD.setNombreMedico(cita.getNombreMedico());
            citaBD.setFechaCita(cita.getFechaCita());
            citaBD.setMotivo(cita.getMotivo());
            citaBD.setClinica(cita.getClinica());
            // citaBD.setPrioridad(cita.getPrioridad());
            citaBD.setPaciente(cita.getPaciente());
            citaBD.setIdDoctorMongo(cita.getIdDoctorMongo());
            return Optional.of(citaRepository.save(citaBD));
        }).orElse(Optional.empty());
    }

    @Override
    public void remove(Long id) {
        citaRepository.deleteById(id);
    }

    

}
