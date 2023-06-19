package com.technocrats.knowladgesharing.backend.service;

import com.technocrats.knowladgesharing.backend.model.PasswordResetToken;
import com.technocrats.knowladgesharing.backend.model.User;
import com.technocrats.knowladgesharing.backend.repository.PasswordResetTokenRepository;
import com.technocrats.knowladgesharing.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResetPasswordService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;

    public void resetPassword(String email, String newPassword) throws Exception {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new Exception("User not found");
        }

        user.setPassword(newPassword); // Store the new password as it is (without encoding)
        userRepository.save(user);

        // Optionally, you can delete the password reset token here
        PasswordResetToken token = passwordResetTokenRepository.findByToken(user.getEmail());
        if (token != null) {
            passwordResetTokenRepository.delete(token);
        }
    }
}
