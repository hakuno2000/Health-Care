package com.ashina.healthcare.repo;

import com.ashina.healthcare.entity.CheckUpForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CheckUpFormRepo extends JpaRepository<CheckUpForm, Long> {
    List<CheckUpForm> findAllByPatient(Long patient);
    CheckUpForm findTopByOrderByFormIDDesc();

    @Query(value = "SELECT c.* FROM checkupform c JOIN prescription p ON c.formID = p.checkUpForm WHERE p.doctor = ?1 AND c.resolved IS NULL", nativeQuery = true)
    List<CheckUpForm> findAllByDoctor(Long doctor);

    @Modifying
    @Transactional
    @Query(value = "UPDATE checkupform c SET c.resolved = ?2 WHERE c.formID = ?1",nativeQuery = true)
    void updateCheckUpFormResolvedByFormID(Long formID, Boolean resolved);
}
