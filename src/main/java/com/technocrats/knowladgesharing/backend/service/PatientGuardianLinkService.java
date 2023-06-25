package com.technocrats.knowladgesharing.backend.service;

import com.technocrats.knowladgesharing.backend.model.PatientGuardianLink;
import com.technocrats.knowladgesharing.backend.repository.PatientGuardianLinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientGuardianLinkService {
    private final PatientGuardianLinkRepository patientGuardianLinkRepository;

    @Autowired
    public PatientGuardianLinkService(PatientGuardianLinkRepository patientGuardianLinkRepository) {
        this.patientGuardianLinkRepository = patientGuardianLinkRepository;
    }

    public PatientGuardianLink addPatientGuardianLink(Long pId) {
        PatientGuardianLink patientGuardianLink = new PatientGuardianLink();
        patientGuardianLink.setPId(pId);
        // Generate and set G_ID as needed
        // ...
        System.out.println(pId);
        return patientGuardianLinkRepository.save(patientGuardianLink);
    }

    // Add other service methods as needed
}
