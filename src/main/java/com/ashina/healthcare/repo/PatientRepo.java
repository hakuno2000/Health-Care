package com.ashina.healthcare.repo;

import com.ashina.healthcare.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Long> {
    List<Patient> findAll();
    Patient findFirstByPatientID(Long id);

    @Query(value = "SELECT p.* FROM patients p JOIN users u on p.patientID = u.userID WHERE userName LIKE CONCAT(\"%\",?1,\"%\")", nativeQuery = true)
    List<Patient> findByUserNameContaining(String userName);
}
