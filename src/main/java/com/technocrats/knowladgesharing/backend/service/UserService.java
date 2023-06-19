package com.technocrats.knowladgesharing.backend.service;

import com.technocrats.knowladgesharing.backend.exception.ResourceNotFoundException;
import com.technocrats.knowladgesharing.backend.model.User;
import com.technocrats.knowladgesharing.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.RandomStringUtils;
import com.technocrats.knowladgesharing.backend.service.EmailService;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User adduser(User user){
        if (user.getUser_type().equalsIgnoreCase("patient")) {
            generateAndSaveOTP(user); // Generate and save OTP for the patient
        }
        return userRepository.save(user);
    }
    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("User","Id",id));
    }

    public User login(String email, String password) throws Exception {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new Exception("Invalid email or password");
        }
        if (!password.equals(user.getPassword())) {
            throw new Exception("Invalid email or password");
        }
        user.setUid(user.getUid());
        return user;
    }

    //edit
    public User updateUser(Long id, User user) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

        existingUser.setFirstname(user.getFirstname());
        existingUser.setLastname(user.getLastname());
        existingUser.setEmail(user.getEmail());
        existingUser.setNIC(user.getNIC());
        existingUser.setProfilePictureUrl(user.getProfilePictureUrl());

        return userRepository.save(existingUser);
    }

    //edit password
    public User updateUserPassword(Long id, String currentPassword, String newPassword) throws InvalidPasswordException {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

        // Check if current password matches saved password in database
        if (!user.getPassword().equals(currentPassword)) {
            throw new InvalidPasswordException("Current password does not match.");
        }

        // Update user's password with new password
        user.setPassword(newPassword);
        return userRepository.save(user);
    }

    public void generateAndSaveOTP(User user) {
        // Generate a 6-digit OTP
        String otp = RandomStringUtils.randomNumeric(6);
        user.setOtp(otp);
        userRepository.save(user);

        // Send the OTP to the user's email
        emailService.sendOTP(user.getEmail(), otp);
    }

    public boolean verifyOTP(String email, String enteredOTP) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            // User not found
            return false;
        }

        String storedOTP = user.getOtp();

        // Compare the entered OTP with the stored OTP
        return enteredOTP.equals(storedOTP);
    }
    public void eraseOTP(String email) {
        // Retrieve the user by email
        User user = userRepository.findByEmail(email);

        // Check if the user exists
        if (user != null) {
            // Erase the OTP for the user
            user.setOtp(null);
            userRepository.save(user);
        }
    }

    public void resendOTP(String email) throws ResourceNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new ResourceNotFoundException("User", "email", email);
        }

        // Erase the existing OTP
        user.setOtp(null);
        userRepository.save(user);

        // Generate and send a new OTP
        generateAndSaveOTP(user);
    }

}