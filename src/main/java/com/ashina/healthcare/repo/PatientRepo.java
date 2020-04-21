package com.ashina.healthcare.repo;

import com.ashina.healthcare.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Long> {
    List<Patient> findAll();
    Patient findFirstByPatientID(Long id);
}
