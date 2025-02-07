package com.citasapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.citasapp.model.NoSQL.Doctores;

@Repository
public interface DoctorRepository extends MongoRepository<Doctores, String> {
}

