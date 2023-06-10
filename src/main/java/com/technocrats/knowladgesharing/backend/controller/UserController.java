package com.technocrats.knowladgesharing.backend.controller;


import com.technocrats.knowladgesharing.backend.model.User;
import com.technocrats.knowladgesharing.backend.service.ErrorResponse;
import com.technocrats.knowladgesharing.backend.service.UserLoginRequest;
import com.technocrats.knowladgesharing.backend.service.PasswordUpdateRequest;
import com.technocrats.knowladgesharing.backend.service.UserRequestObject;
import com.technocrats.knowladgesharing.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;


@RestController
@CrossOrigin("http://192.168.8.167")
@RequestMapping("/api/users") //edit
public class UserController {
    @Autowired
    private  UserService userService;

    @GetMapping("/getuser")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("getuserbyid/{id}")
    public User getuserbyid(@PathVariable Long id){
        return userService.getUserById(id);
    }

// add new user to database
    @PostMapping("/adduser")
    public User adduser(@RequestBody UserRequestObject userRequestObject){
        User user=new User();
        user.setFirstname(userRequestObject.getFirstname());
        user.setLastname(userRequestObject.getLastname());
        user.setNIC(userRequestObject.getNIC());
        user.setEmail(userRequestObject.getEmail());
        user.setPassword(userRequestObject.getPassword());
        //user.setUser_type(userRequestObject.getUser_type());
        if (userRequestObject.getUser_type() == null) {
            user.setUser_type("patient"); // default user type for patients
        } else {
            user.setUser_type(userRequestObject.getUser_type());
        }
        return userService.adduser(user);
    }

//login function of user
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginRequest userLoginRequest) {
        try {
            User user = userService.login(userLoginRequest.getEmail(), userLoginRequest.getPassword());
            return ResponseEntity.ok().body(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse("Invalid email or password"));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }


    @PutMapping("/{id}")  //edit
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        return ResponseEntity.ok(updatedUser);
    }

    @PutMapping("/{id}/password")
    public ResponseEntity<String> updatePassword(@PathVariable("id") Long userId, @RequestBody PasswordUpdateRequest request) {
        try {
            userService.updateUserPassword(userId, request.getCurrentPassword(), request.getNewPassword());
            return ResponseEntity.ok("Password updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating password");
        }
    }


}
