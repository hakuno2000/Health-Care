package com.ashina.healthcare.repo;

import com.ashina.healthcare.entity.CheckUpForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckUpFormRepo extends JpaRepository<CheckUpForm, Long> {
    List<CheckUpForm> findAllByPatient(Long patient);
}
