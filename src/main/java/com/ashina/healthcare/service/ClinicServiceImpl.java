package com.ashina.healthcare.service;

import com.ashina.healthcare.entity.Clinic;
import com.ashina.healthcare.repo.ClinicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicServiceImpl implements ClinicService{
    @Autowired
    private ClinicRepo clinicRepo;
    @Override
    public List<Clinic> findAll() {
        return clinicRepo.findAll();
    }

    @Override
    public List<Clinic> findAllByClinicNameContaining(String clinicName) {
        return clinicRepo.findAllByClinicNameContaining(clinicName);
    }
}
