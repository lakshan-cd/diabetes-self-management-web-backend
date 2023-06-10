package com.technocrats.knowladgesharing.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.technocrats.knowladgesharing.backend.service.ForgotPasswordService;
import com.technocrats.knowladgesharing.backend.service.ForgotPasswordRequest;


@RestController
public class ForgotPasswordController {
    @Autowired
    private ForgotPasswordService forgotPasswordService;

    @PostMapping("/forgot-password")
    public ResponseEntity<Object> forgotPassword(@RequestBody ForgotPasswordRequest forgotPasswordRequest) {
        try {
            forgotPasswordService.forgotPassword(forgotPasswordRequest.getEmail());
            return new ResponseEntity<>("Reset link sent successfully", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error sending reset link: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}

