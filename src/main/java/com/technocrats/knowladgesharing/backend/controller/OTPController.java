package com.technocrats.knowladgesharing.backend.controller;

import com.technocrats.knowladgesharing.backend.service.UserService;
import com.technocrats.knowladgesharing.backend.service.VerificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@CrossOrigin("http://192.168.8.167")
@RequestMapping("/api/users") //edit
public class OTPController {

    @Autowired
    private UserService userService;

    @PostMapping("/verify-otp")
    public ResponseEntity<String> verifyOTP(@RequestBody VerificationRequest request) {
        String email = request.getEmail();
        String otp = request.getOtp();

        boolean isOTPValid = userService.verifyOTP(email, otp);
        System.out.println("Is OTP Valid? " + isOTPValid);
        if (isOTPValid) {
            // OTP is valid, navigate to the login page and erase the saved OTP
            userService.eraseOTP(email);
            return ResponseEntity.ok("OTP verification successful. Redirecting to login page.");
        } else {
            // OTP is invalid, return an error response
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid OTP");
        }
    }

}
