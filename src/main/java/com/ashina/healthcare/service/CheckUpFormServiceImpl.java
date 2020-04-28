package com.ashina.healthcare.service;

import com.ashina.healthcare.entity.CheckUpForm;
import com.ashina.healthcare.repo.CheckUpFormRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckUpFormServiceImpl implements CheckUpFormService{
    @Autowired
    private CheckUpFormRepo checkUpFormRepo;

    @Override
    public List<CheckUpForm> findAllByPatient(Long patient) {
        return checkUpFormRepo.findAllByPatient(patient);
    }

    @Override
    public List<CheckUpForm> findAllByDoctor(Long doctor) {
        return checkUpFormRepo.findAllByDoctor(doctor);
    }

    @Override
    public void updateCheckUpFormResolvedByFormID(Long formID, Boolean resolved) {
        checkUpFormRepo.updateCheckUpFormResolvedByFormID(formID, resolved);
    }

    @Override
    public CheckUpForm findTopByOrderByFormIDDesc() {
        return checkUpFormRepo.findTopByOrderByFormIDDesc();
    }

    @Override
    public void save(CheckUpForm checkUpForm) {
        checkUpFormRepo.save(checkUpForm);
    }
}
