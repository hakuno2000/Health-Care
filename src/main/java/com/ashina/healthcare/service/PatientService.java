package com.ashina.healthcare.service;

import com.ashina.healthcare.entity.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> findAll();
    Patient findFirstByPatientID(Long id);
    void save(Patient patient);
    void delete(Patient patient);
}
