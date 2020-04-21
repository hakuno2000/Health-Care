package com.ashina.healthcare.entity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class ApiController {
    @GetMapping("/search")
    public void searchAllPatient(HttpServletResponse response) throws IOException {
        response.sendRedirect("/patient");
    }
}
