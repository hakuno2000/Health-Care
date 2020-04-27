package com.ashina.healthcare.controller;

import com.ashina.healthcare.support.ResponeMessage;
import com.ashina.healthcare.entity.User;
import com.ashina.healthcare.service.UserService;
import com.ashina.healthcare.support.ResponeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/api/login")
    public ResponseEntity<Object> login(@RequestBody User userInput) {
        User matchedUser = userService.findFirstByEmail(userInput.getEmail());
        if (matchedUser == null) return ResponseEntity.notFound().build();
        if (!matchedUser.getUserPassword().equals(userInput.getUserPassword())) return ResponseEntity.badRequest().body(new ResponeMessage("Password không khớp"));
        ResponeData responeData = new ResponeData();
        if (matchedUser.getUserID() < 10000000) responeData.setRole("doctor");
        return ResponseEntity.ok().body(responeData);
    }

    @RequestMapping("/api/signup")
    public ResponseEntity<Object> createNewUser(@RequestBody User newUser) {
        User matchedUser = userService.findFirstByUserName(newUser.getUserName());
        if (matchedUser == null) {
            User currentTopId = userService.findTopByOrderByUserIDDesc();
            newUser.setUserID(currentTopId.getUserID() + 1);
            userService.save(newUser);
            ResponeData responeData = new ResponeData();
            return ResponseEntity.ok().body(responeData);
        } else return ResponseEntity.badRequest().body(new ResponeMessage("User này đã tồn tại"));
    }

    /*@DeleteMapping("/user/delete")
    public void deleteUser(@RequestBody User user) {
        User matchedUser = userService.findFirstByUserName(user.getUserName());
        if (matchedUser != null) userService.delete(matchedUser);
    }*/
}
