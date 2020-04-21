package com.ashina.healthcare.controller;

import com.ashina.healthcare.entity.Patient;
import com.ashina.healthcare.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping("/patient")
    public List<Patient> getAllPatient() {
        return patientService.findAll();
    }

    @GetMapping("/patient/{id}")
    public Patient getPatientById(@PathVariable("id") Long id) {
        return patientService.findFirstByPatientID(id);
    }

    @PostMapping("/patient/create")
    public void createNewPatient(@RequestBody Patient patient) {
        patientService.save(patient);
    }
}
