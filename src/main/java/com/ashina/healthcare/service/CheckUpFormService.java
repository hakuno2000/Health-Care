package com.ashina.healthcare.service;

import com.ashina.healthcare.entity.CheckUpForm;

import java.util.List;

public interface CheckUpFormService {
    List<CheckUpForm> findAllByPatient(Long patient);
    List<CheckUpForm> findAllByDoctor(Long doctor);
    void updateCheckUpFormResolvedByFormID(Long formID, Boolean resolved);
    CheckUpForm findTopByOrderByFormIDDesc();
    void save(CheckUpForm checkUpForm);
}
