package com.ashina.healthcare.controller;

import com.ashina.healthcare.entity.CheckUpForm;
import com.ashina.healthcare.entity.Patient;
import com.ashina.healthcare.entity.Prescription;
import com.ashina.healthcare.entity.User;
import com.ashina.healthcare.service.CheckUpFormService;
import com.ashina.healthcare.service.PatientService;
import com.ashina.healthcare.service.PrescriptionService;
import com.ashina.healthcare.service.UserService;
import com.ashina.healthcare.support.ResponseInfo;
import com.ashina.healthcare.support.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class PatientController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private CheckUpFormService checkUpFormService;
    @Autowired
    private PrescriptionService prescriptionService;
    @Autowired
    private UserService userService;

    @GetMapping("/patient")
    public List<Patient> getAllPatient() {
        return patientService.findAll();
    }

    @GetMapping("/patient/{id}")
    public ResponseEntity<Object> getPatientById(@PathVariable("id") Long id) {
        Patient matchedPatient = patientService.findFirstByPatientID(id);
        if (matchedPatient == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(matchedPatient);
    }

    @GetMapping("/patient/{id}/checkupform")
    public ResponseEntity<Object> getAllCheckUpFormByPatient(@PathVariable("id") Long patient) {
        Patient matchedPatient = patientService.findFirstByPatientID(patient);
        if (matchedPatient == null) return ResponseEntity.notFound().build();
        List<CheckUpForm> checkUpFormList = checkUpFormService.findAllByPatient(matchedPatient.getPatientID());
        return ResponseEntity.ok().body(checkUpFormList);
    }

    @GetMapping("/patient/{id}/prescription")
    public ResponseEntity<Object> getAllPresciptionByPatient(@PathVariable("id") Long patient) {
        Patient matchedPatient = patientService.findFirstByPatientID(patient);
        if (matchedPatient == null) return ResponseEntity.notFound().build();
        List<Prescription> presciptionList = prescriptionService.findAllByPatient(matchedPatient.getPatientID());
        return ResponseEntity.ok().body(presciptionList);
    }

    @RequestMapping("/api/search")
    public ResponseEntity<Object> findPatientByUserNameContaining(@RequestParam("search") String search, @RequestParam("data") String email) {
        /*List<Patient> patients = patientService.findByUserNameContaining(userName);
        ResponseResult responseResult = new ResponseResult();
        responseResult.setResult(patients);
        return ResponseEntity.ok().body(responseResult);*/
        List<User> users = userService.findByEmailContaining(email);
        ResponseResult responseResult = new ResponseResult();
        responseResult.setResult(users);
        return ResponseEntity.ok().body(responseResult);
    }
}
