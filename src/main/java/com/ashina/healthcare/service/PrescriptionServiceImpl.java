package com.ashina.healthcare.service;

import com.ashina.healthcare.entity.Prescription;
import com.ashina.healthcare.repo.PrescriptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {
    @Autowired
    private PrescriptionRepo prescriptionRepo;
    @Override
    public List<Prescription> findAllByPatient(Long patient) {
        return prescriptionRepo.findAllByPatient(patient);
    }

    @Override
    public Prescription findTopByOrderByPresciptionIDDesc() {
        return prescriptionRepo.findTopByOrderByPresciptionIDDesc();
    }

    @Override
    public void save(Prescription prescription) {
        prescriptionRepo.save(prescription);
    }
}
