package com.ashina.healthcare.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequestMapping
@CrossOrigin(origins = "http://localhost:8080")
public class MainController {
    @GetMapping("")
    public void searchAllPatient(HttpServletResponse response) throws IOException {
        response.sendRedirect("/home");
    }
}
