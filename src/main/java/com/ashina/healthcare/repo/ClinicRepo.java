package com.ashina.healthcare.repo;

import com.ashina.healthcare.entity.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClinicRepo extends JpaRepository<Clinic, Long> {
    List<Clinic> findAll();
    List<Clinic> findAllByClinicNameContaining(String clinicName);
}
