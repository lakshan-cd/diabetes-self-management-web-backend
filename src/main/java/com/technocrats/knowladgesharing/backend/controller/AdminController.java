package com.technocrats.knowladgesharing.backend.controller;

import com.technocrats.knowladgesharing.backend.dto.AdminInputRequest;
import com.technocrats.knowladgesharing.backend.model.Admin;
import com.technocrats.knowladgesharing.backend.repository.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class AdminController {
    @Autowired
    private AdminRepository adminRepository;
//    @Autowired
//    private WorkoutsRepository workoutsRepository;

    @PostMapping("/adminadddata")
    public Admin addData(@RequestBody AdminInputRequest request){

        return adminRepository.save(request.getAdmin());
    }

    @GetMapping("/gettingdata")
    public List<Admin> findData(){
        return adminRepository.findAll();
    }

}
