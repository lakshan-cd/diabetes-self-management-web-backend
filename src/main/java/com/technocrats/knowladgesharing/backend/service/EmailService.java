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

        String userType = user.getUser_type();
        String subject = "Account Details";

        // Customize the email content based on the user type
        String emailContent = "";
        if (userType.equals("Guardian")) {
            emailContent = "Your account has been created with the following details:\n" +
                    "Username: " + user.getEmail() + "\n" +
                    "Password: " + user.getPassword() + "\n\n" +
                    "Please keep this information secure.\n\n" +
                    "Regards,\n" +
                    "Diamate";
        } else if (userType.equals("Doctor")) {
            subject = "Doctor Account Details";
            emailContent = "Dear Doctor,\n\n" +
                    "Your doctor account has been created with the following details:\n" +
                    "Username: " + user.getEmail() + "\n" +
                    "Password: " + user.getPassword() + "\n\n" +
                    "Please keep this information secure.\n\n" +
                    "Regards,\n" +
                    "Diamate";
        } else if (userType.equals("Nutritionist")) {
            subject = "Nutritionist Account Details";
            emailContent = "Dear Nutritionist,\n\n" +
                    "Your nutritionist account has been created with the following details:\n" +
                    "Username: " + user.getEmail() + "\n" +
                    "Password: " + user.getPassword() + "\n\n" +
                    "Please keep this information secure.\n\n" +
                    "Regards,\n" +
                    "Diamate";
        }

        // Send an email with the customized content
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject(subject);
        message.setText(emailContent);

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
