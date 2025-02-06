package com.citasapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citasapp.model.SQL.Clinica;
import com.citasapp.service.IClinicaService;

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
    public Respowa
}
