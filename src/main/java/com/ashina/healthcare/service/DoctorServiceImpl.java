package com.ashina.healthcare.service;

import com.ashina.healthcare.entity.Doctor;
import com.ashina.healthcare.repo.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService{
    @Autowired
    private DoctorRepo doctorRepo;

    @Override
    public Doctor findFirstByDoctorID(Long doctorID) {
        return doctorRepo.findFirstByDoctorID(doctorID);
    }
}
