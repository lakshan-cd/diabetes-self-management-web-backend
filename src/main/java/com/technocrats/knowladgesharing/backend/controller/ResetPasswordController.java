package com.technocrats.knowladgesharing.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.technocrats.knowladgesharing.backend.service.ResetPasswordService;
import com.technocrats.knowladgesharing.backend.service.ResetPasswordRequest;

@RestController
@CrossOrigin("http://192.168.8.167")
@RequestMapping("/api/users")
public class ResetPasswordController {
    @Autowired
    private ResetPasswordService resetPasswordService;

    @PostMapping("/reset-password")
    public ResponseEntity<Object> resetPassword(@RequestBody ResetPasswordRequest resetPasswordRequest) {
        try {
            resetPasswordService.resetPassword(resetPasswordRequest.getEmail(), resetPasswordRequest.getPassword());
            return new ResponseEntity<>("Password reset successful", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error resetting password: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
