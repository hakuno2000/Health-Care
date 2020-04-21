package com.ashina.healthcare.service;

import com.ashina.healthcare.entity.Patient;
import com.ashina.healthcare.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService{
    @Autowired
    private PatientRepo patientRepo;

    @Override
    public List<Patient> findAll() {
        return patientRepo.findAll();
    }

    @Override
    public Patient findFirstByPatientID(Long id) {
        return patientRepo.findFirstByPatientID(id);
    }

    @Override
    public void save(Patient patient) {
        patientRepo.save(patient);
    }

    @Override
    public void delete(Patient patient) {
        patientRepo.delete(patient);
    }
}
