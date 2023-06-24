package com.technocrats.knowladgesharing.backend.service;

import com.technocrats.knowladgesharing.backend.model.PasswordResetToken;
import com.technocrats.knowladgesharing.backend.model.User;
import com.technocrats.knowladgesharing.backend.repository.PasswordResetTokenRepository;
import com.technocrats.knowladgesharing.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;
@Service
public class ForgotPasswordService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private EmailService emailService;

    public void forgotPassword(String email) throws Exception {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new Exception("User not found");
        }

        // Generate a new password
        String newPassword = generateRandomPassword(8);

        // Update the user's password in the database
        user.setPassword(newPassword);
        userRepository.save(user);

        // Create a new password reset token and save it in the database
//        PasswordResetToken passwordResetToken = new PasswordResetToken(user);
//        passwordResetTokenRepository.save(passwordResetToken);

        // Send an email to the user with the new password and the password reset link
        emailService.sendNewPassword(email, newPassword);
    }

    private String generateRandomPassword(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(chars.length());
            sb.append(chars.charAt(index));
        }
        return sb.toString();
    }
}
