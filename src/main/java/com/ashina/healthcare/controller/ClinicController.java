package com.ashina.healthcare.controller;

import com.ashina.healthcare.entity.Clinic;
import com.ashina.healthcare.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClinicController {
    @Autowired
    private ClinicService clinicService;

    @GetMapping("/clinic")
    public List<Clinic> getAllClinic() {
        return clinicService.findAll();
    }

    @GetMapping("/clinic/search/{name}")
    public List<Clinic> getClinicByNameContaining(@PathVariable("name") String cliniName) {
        return clinicService.findAllByClinicNameContaining(cliniName);
    }
}
