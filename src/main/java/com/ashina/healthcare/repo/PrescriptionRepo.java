package com.ashina.healthcare.repo;

import com.ashina.healthcare.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrescriptionRepo extends JpaRepository<Prescription, Long> {
    @Query(value = "SELECT p.* FROM checkupform c JOIN prescription p ON c.formID = p.checkUpForm WHERE c.patient = ?1", nativeQuery = true)
    List<Prescription> findAllByPatient(Long patient);

    Prescription findTopByOrderByPresciptionIDDesc();
}
