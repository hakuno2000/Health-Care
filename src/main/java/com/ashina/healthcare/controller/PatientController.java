package com.ashina.healthcare.controller;

import com.ashina.healthcare.entity.*;
import com.ashina.healthcare.service.*;
import com.ashina.healthcare.support.CheckUpFormResult;
import com.ashina.healthcare.support.ClinicResult;
import com.ashina.healthcare.support.UserResult;
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
    @Autowired
    private ClinicService clinicService;

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
    public ResponseEntity<Object> findPatientByUserNameContaining(@RequestHeader(value = "Authorization") String authorization, @RequestParam("search") String search, @RequestParam("data") String data) {
        if (search.equals("patient")) {
            List<User> users = userService.findPatientByEmailContaining(data);
            UserResult userResult = new UserResult();
            userResult.setResult(users);
            return ResponseEntity.ok().body(userResult);
        } else if (search.equals("clinic")) {
            List<Clinic> clinics = clinicService.findAllByClinicNameContaining(data);
            ClinicResult clinicResult = new ClinicResult();
            clinicResult.setResult(clinics);
            return ResponseEntity.ok().body(clinicResult);
        } else {
            Long patient = Long.parseLong(authorization.split(" ")[1]);
            User matchedUser = userService.findByUserID(patient);
            if (matchedUser == null) return ResponseEntity.badRequest().build();

            List<CheckUpForm> checkUpForms = checkUpFormService.findAllByPatient(patient);
            CheckUpFormResult checkUpFormResult = new CheckUpFormResult();
            checkUpFormResult.setResult(checkUpForms);
            return ResponseEntity.ok().body(checkUpFormResult);
        }
    }
}
