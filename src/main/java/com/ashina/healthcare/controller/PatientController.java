package com.ashina.healthcare.controller;

import com.ashina.healthcare.entity.CheckUpForm;
import com.ashina.healthcare.entity.Patient;
import com.ashina.healthcare.service.CheckUpFormService;
import com.ashina.healthcare.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private CheckUpFormService checkUpFormService;

    @GetMapping("/patient")
    public List<Patient> getAllPatient() {
        return patientService.findAll();
    }

    @GetMapping("/patient/{id}")
    public ResponseEntity<Object> getPatientById(@PathVariable("id") Long id) {
        Patient matchedPatient = patientService.findFirstByPatientID(id);
        if (matchedPatient == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(matchedPatient);
    }

    @GetMapping("/patient/{id}/checkupform")
    public ResponseEntity<Object> getAllCheckUpFormByPatient(@PathVariable("id") Long patient) {
        Patient matchedPatient = patientService.findFirstByPatientID(patient);
        if (matchedPatient == null) return ResponseEntity.notFound().build();
        List<CheckUpForm> checkUpFormList = checkUpFormService.findAllByPatient(matchedPatient.getPatientID());
        return ResponseEntity.ok().body(checkUpFormList);
    }
}
