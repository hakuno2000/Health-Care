package com.ashina.healthcare.controller;

import com.ashina.healthcare.entity.CheckUpForm;
import com.ashina.healthcare.entity.User;
import com.ashina.healthcare.service.CheckUpFormService;
import com.ashina.healthcare.service.UserService;
import com.ashina.healthcare.support.Form;
import com.ashina.healthcare.support.RequestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class CheckUpFormController {
    @Autowired
    private UserService userService;
    @Autowired
    private CheckUpFormService checkUpFormService;

    @GetMapping("/api/form")
    public ResponseEntity<Object> getAllCheckUpFormByDoctor(@RequestHeader(value = "Authorization") String authorization) {
        Long doctor = Long.parseLong(authorization.split(" ")[1]);
        User matchedUser = userService.findByUserID(doctor);
        if (matchedUser == null) return ResponseEntity.badRequest().build();
        Form form = new Form();
        form.setForms(checkUpFormService.findAllByDoctor(doctor));
        return ResponseEntity.ok().body(form);
    }

    @PatchMapping("/api/form")
    public ResponseEntity<Object> updateCheckUpFormResolvedByFormID(@RequestBody RequestData requestData) {
        checkUpFormService.updateCheckUpFormResolvedByFormID(requestData.getFormID(), requestData.getValue());
        return ResponseEntity.ok().body(null);
    }

    @PostMapping("/api/form")
    public ResponseEntity<Object> saveCheckUpForm(@RequestHeader(value = "Authorization") String authorization, @RequestBody CheckUpForm checkUpForm) {
        Long patient = Long.parseLong(authorization.split(" ")[1]);
        User matchedUser = userService.findByUserID(patient);
        if (matchedUser == null) return ResponseEntity.badRequest().build();

        checkUpForm.setPatient(patient);
        checkUpForm.setFormID(checkUpFormService.findTopByOrderByFormIDDesc().getFormID() + 1);
        checkUpForm.setResolved(null);
        checkUpFormService.save(checkUpForm);
        return ResponseEntity.ok().body(null);
    }
}
