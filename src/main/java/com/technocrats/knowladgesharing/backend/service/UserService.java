package com.technocrats.knowladgesharing.backend.service;

import com.technocrats.knowladgesharing.backend.exception.ResourceNotFoundException;
import com.technocrats.knowladgesharing.backend.model.User;
import com.technocrats.knowladgesharing.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User adduser(User user){
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

}
