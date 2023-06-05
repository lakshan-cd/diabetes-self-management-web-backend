package com.technocrats.knowladgesharing.backend.service;

import com.technocrats.knowladgesharing.backend.model.PasswordResetToken;
import com.technocrats.knowladgesharing.backend.model.User;
import com.technocrats.knowladgesharing.backend.repository.PasswordResetTokenRepository;
import com.technocrats.knowladgesharing.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ForgotPasswordService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;

    @Autowired
    private JavaMailSender mailSender;

    public void forgotPassword(String email) throws Exception {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new Exception("User not found");
        }

        // Create a new password reset token and save it in the database
        PasswordResetToken passwordResetToken = new PasswordResetToken(user);
        passwordResetTokenRepository.save(passwordResetToken);

        // Send an email to the user with the password reset link
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Password Reset Request");
        message.setText("Please click on the following link to reset your password: http://localhost:3000/reset-password?token=" + passwordResetToken.getToken());
        mailSender.send(message);
    }
}
