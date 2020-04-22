package com.ashina.healthcare.service;

import com.ashina.healthcare.entity.Prescription;

import java.util.List;

public interface PrescriptionService {
    List<Prescription> findAllByPatient(Long patient);
}
