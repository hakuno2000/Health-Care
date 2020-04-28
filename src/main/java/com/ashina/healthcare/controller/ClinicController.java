package com.ashina.healthcare.controller;

import com.ashina.healthcare.entity.Clinic;
import com.ashina.healthcare.service.ClinicService;
import com.ashina.healthcare.support.ClinicResult;
import com.ashina.healthcare.support.UserResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class ClinicController {
    @Autowired
    private ClinicService clinicService;

    @GetMapping("/api/search/clinics")
    public ResponseEntity<Object> getAllClinic() {
        List<Clinic> clinics = clinicService.findAll();
        ClinicResult clinicResult = new ClinicResult();
        clinicResult.setResult(clinics);
        return ResponseEntity.ok().body(clinicResult);
    }

    @GetMapping("/clinic/search/{name}")
    public List<Clinic> getClinicByNameContaining(@PathVariable("name") String clinicName) {
        return clinicService.findAllByClinicNameContaining(clinicName);
    }
}
