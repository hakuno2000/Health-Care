package com.ashina.healthcare.controller;

import com.ashina.healthcare.entity.Patient;
import com.ashina.healthcare.service.DoctorService;
import com.ashina.healthcare.service.PatientService;
import com.ashina.healthcare.support.ResponseMessage;
import com.ashina.healthcare.entity.User;
import com.ashina.healthcare.service.UserService;
import com.ashina.healthcare.support.ResponseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorService doctorService;

    @RequestMapping("/api/login")
    public ResponseEntity<Object> login(@RequestBody User userInput) {
        User matchedUser = userService.findFirstByEmail(userInput.getEmail());
        if (matchedUser == null) return ResponseEntity.notFound().build();
        if (!matchedUser.getUserPassword().equals(userInput.getUserPassword())) return ResponseEntity.badRequest().body(new ResponseMessage("Password không khớp"));

        ResponseInfo responseInfo = new ResponseInfo();
        responseInfo.setToken(matchedUser.getUserID().toString());

//        if (matchedUser.getUserID() < 10000000) responseInfo.setRole("doctor");
        Patient matchedPatient = patientService.findFirstByPatientID(matchedUser.getUserID());
        if (matchedPatient != null) responseInfo.setRole("patient");
        else responseInfo.setRole("doctor");
        return ResponseEntity.ok().body(responseInfo);
    }

    @RequestMapping("/api/signup")
    public ResponseEntity<Object> createNewUser(@RequestBody User newUser) {
        User matchedUser = userService.findFirstByUserName(newUser.getUserName());
        if (matchedUser == null) {
            User currentTopId = userService.findTopByOrderByUserIDDesc();
            newUser.setUserID(currentTopId.getUserID() + 1);
            userService.save(newUser);
            ResponseInfo responseInfo = new ResponseInfo();
            responseInfo.setToken(newUser.getUserID().toString());
            Patient patient = new Patient();
            patient.setPatientID(newUser.getUserID());
            patientService.save(patient);
            return ResponseEntity.ok().body(responseInfo);
        } else return ResponseEntity.badRequest().body(new ResponseMessage("User này đã tồn tại"));
    }

    /*@DeleteMapping("/user/delete")
    public void deleteUser(@RequestBody User user) {
        User matchedUser = userService.findFirstByUserName(user.getUserName());
        if (matchedUser != null) userService.delete(matchedUser);
    }*/
}
