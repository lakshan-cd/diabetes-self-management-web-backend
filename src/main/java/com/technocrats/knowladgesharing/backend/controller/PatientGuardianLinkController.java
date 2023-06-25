package com.technocrats.knowladgesharing.backend.controller;

import com.technocrats.knowladgesharing.backend.model.PatientGuardianLink;
import com.technocrats.knowladgesharing.backend.service.PatientGuardianLinkService;
import com.technocrats.knowladgesharing.backend.service.PatientGuardianLinkObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/users")
public class PatientGuardianLinkController {
    private PatientGuardianLinkService patientGuardianLinkService;

    @Autowired
    public PatientGuardianLinkController(PatientGuardianLinkService patientGuardianLinkService) {
        this.patientGuardianLinkService = patientGuardianLinkService;
    }

    @PostMapping("/addGuardian")
    public PatientGuardianLink addPatientGuardianLink(@RequestBody PatientGuardianLinkObject patientGuardianLinkObject) {
        //Long hardcodedPId = 12345L;
        System.out.println(patientGuardianLinkObject.getPId());
        return patientGuardianLinkService.addPatientGuardianLink(patientGuardianLinkObject.getPId());
    }

    // Add other endpoints as needed
}
