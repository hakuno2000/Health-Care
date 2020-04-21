package com.ashina.healthcare.service;

import com.ashina.healthcare.entity.CheckUpForm;

import java.util.List;

public interface CheckUpFormService {
    List<CheckUpForm> findAllByPatient(Long patient);
    void save(CheckUpForm checkUpForm);
}
