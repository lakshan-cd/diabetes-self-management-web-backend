package com.technocrats.knowladgesharing.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.technocrats.knowladgesharing.backend.service.ForgotPasswordService;
import com.technocrats.knowladgesharing.backend.service.ForgotPasswordRequest;


@RestController
@CrossOrigin("http://192.168.8.167")
@RequestMapping("/api/users")
public class ForgotPasswordController {
    @Autowired
    private ForgotPasswordService forgotPasswordService;

    @PostMapping("/forgot-password")
    public void forgotPassword(@RequestBody ForgotPasswordRequest request) throws Exception {
        String email = request.getEmail();
        forgotPasswordService.forgotPassword(email);
    }
}

