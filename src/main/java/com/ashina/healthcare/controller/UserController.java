package com.ashina.healthcare.controller;

import com.ashina.healthcare.support.ResponeMessage;
import com.ashina.healthcare.entity.User;
import com.ashina.healthcare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/api")
    public ResponseEntity<Object> login(@RequestBody User userInput) {
        User matchedUser = userService.findFirstByUserName(userInput.getUserName());
        if (matchedUser == null) return ResponseEntity.notFound().build();
        if (!matchedUser.getUserPassword().equals(userInput.getUserPassword())) return ResponseEntity.badRequest().body(new ResponeMessage("Password không khớp"));
        return ResponseEntity.ok().body(matchedUser);
    }

    @PostMapping("/user/create")
    public ResponseEntity<ResponeMessage> createNewUser(@RequestBody User newUser) {
        User matchedUser = userService.findFirstByUserName(newUser.getUserName());
        if (matchedUser == null) {
            userService.save(newUser);
            return ResponseEntity.ok().body(new ResponeMessage("Tạo thành công User mới"));
        } else return ResponseEntity.badRequest().body(new ResponeMessage("User này đã tồn tại"));
    }

    /*@DeleteMapping("/user/delete")
    public void deleteUser(@RequestBody User user) {
        User matchedUser = userService.findFirstByUserName(user.getUserName());
        if (matchedUser != null) userService.delete(matchedUser);
    }*/
}
