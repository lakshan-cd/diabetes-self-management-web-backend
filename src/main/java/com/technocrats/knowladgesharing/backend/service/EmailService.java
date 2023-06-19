package com.technocrats.knowladgesharing.backend.service;

import com.technocrats.knowladgesharing.backend.model.User;
import com.technocrats.knowladgesharing.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender mailSender;

    public void sendUsernameAndPassword(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new RuntimeException("User not found");
        }

        // Send an email to the guardian with the username and password
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Account Details");
        message.setText("Dear Guardian,\n\n" +
                "Your account has been created with the following details:\n" +
                "Username: " + user.getEmail() + "\n" +
                "Password: " + user.getPassword() + "\n\n" +
                "Please keep this information secure.\n\n" +
                "Regards,\n" +
                "Your App");

        mailSender.send(message);
    }

    public void sendOTP(String email, String otp) {
        // Send an email with the OTP
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("OTP Verification");
        message.setText("Your OTP: " + otp);
        mailSender.send(message);
    }

    public void sendNewPassword(String email, String newPassword) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new RuntimeException("User not found");
        }

        // Send an email to the user with the new password and the password reset link
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Password Reset Request");
        message.setText("Your new password is: " + newPassword );
        mailSender.send(message);
    }
}
