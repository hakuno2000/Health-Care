package com.ashina.healthcare.controller;

import com.ashina.healthcare.entity.Prescription;
import com.ashina.healthcare.entity.User;
import com.ashina.healthcare.service.PrescriptionService;
import com.ashina.healthcare.service.UserService;
import com.ashina.healthcare.support.RequestPrescription;
import com.ashina.healthcare.support.ResponsePrescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class PrescriptionController {
    @Autowired
    private PrescriptionService prescriptionService;
    @Autowired
    private UserService userService;

    @PostMapping("/api/prescription")
    public ResponseEntity<Object> savePrescription(@RequestHeader(value = "Authorization") String authorization, @RequestBody RequestPrescription requestPrescription) {
        Long doctor = Long.parseLong(authorization.split(" ")[1]);
        User matchedUser = userService.findByUserID(doctor);
        if (matchedUser == null) return ResponseEntity.badRequest().build();

        Prescription prescription = new Prescription();
        prescription.setCheckUpForm(Long.parseLong(requestPrescription.getForm()));
        prescription.setPresciptionID(prescription.getCheckUpForm());
        prescription.setDoctor(doctor);
        prescriptionService.save(prescription);
        return ResponseEntity.ok().body(null);
    }

    @GetMapping("/api/prescription")
    public ResponseEntity<Object> searchPrescription(@RequestHeader(value = "Authorization") String authorization) {
        Long patient = Long.parseLong(authorization.split(" ")[1]);
        User matchedUser = userService.findByUserID(patient);
        if (matchedUser == null) return ResponseEntity.badRequest().build();

        List<Prescription> prescriptions = prescriptionService.findAllByPatient(patient);
        ResponsePrescription responsePrescription = new ResponsePrescription();
        responsePrescription.setForms(prescriptions);
        return ResponseEntity.ok().body(responsePrescription);
    }
}
