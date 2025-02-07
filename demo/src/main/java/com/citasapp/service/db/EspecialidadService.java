package com.citasapp.service.db;

import com.citasapp.model.NoSQL.Especialidad;
import com.citasapp.repository.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadService {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    // Crear una nueva especialidad
    public Especialidad createEspecialidad(Especialidad especialidad) {
        return especialidadRepository.save(especialidad);
    }

    // Obtener todas las especialidades
    public List<Especialidad> getAllEspecialidades() {
        return especialidadRepository.findAll();
    }

    // Obtener especialidad por ID
    public Optional<Especialidad> getEspecialidadById(String id) {
        return especialidadRepository.findById(id);
    }

    // Actualizar una especialidad
    public Especialidad updateEspecialidad(String id, Especialidad especialidad) {
        if (especialidadRepository.existsById(id)) {
            especialidad.setId(id);  // Asegurarse de que el ID sea el mismo
            return especialidadRepository.save(especialidad);
        } else {
            return null;  // O lanzar una excepción si la especialidad no existe
        }
    }

    // Eliminar una especialidad
    public void deleteEspecialidad(String id) {
        especialidadRepository.deleteById(id);
    }
}
