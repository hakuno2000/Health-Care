package com.ashina.healthcare.service;

import com.ashina.healthcare.entity.Doctor;

public interface DoctorService {
    Doctor findFirstByDoctorID(Long doctorID);
}
