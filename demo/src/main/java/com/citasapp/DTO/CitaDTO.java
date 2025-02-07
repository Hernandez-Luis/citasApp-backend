package com.citasapp.DTO;

import com.citasapp.model.NoSQL.Doctores;
import com.citasapp.model.SQL.Cita;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CitaDTO {
    private Cita cita;
    private Doctores doctores;
}
