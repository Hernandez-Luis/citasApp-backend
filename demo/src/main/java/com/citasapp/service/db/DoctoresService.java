package com.citasapp.service.db;



import com.citasapp.model.NoSQL.Doctores;
import com.citasapp.repository.DoctorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctoresService {

    @Autowired
    private DoctorRepository doctoresRepository;

    // Crear un nuevo doctor
    public Doctores crearDoctor(Doctores doctor) {
        return doctoresRepository.save(doctor);
    }

    // Obtener todos los doctores
    public List<Doctores> obtenerTodosLosDoctores() {
        return doctoresRepository.findAll();
    }

    // Obtener un doctor por su ID
    public Optional<Doctores> obtenerDoctorPorId(String id) {
        return doctoresRepository.findById(id);
    }

    // Actualizar un doctor
    public Doctores actualizarDoctor(String id, Doctores doctor) {
        if (doctoresRepository.existsById(id)) {
            doctor.setId(id);
            return doctoresRepository.save(doctor);
        }
        return null; // o lanzar excepción
    }

    // Eliminar un doctor
    public void eliminarDoctor(String id) {
        doctoresRepository.deleteById(id);
    }
}
