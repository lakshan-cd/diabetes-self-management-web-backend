package com.technocrats.knowladgesharing.backend.repository;

import com.technocrats.knowladgesharing.backend.model.PatientGuardianLink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientGuardianLinkRepository extends JpaRepository<PatientGuardianLink, Long> {
    // Add custom query methods if needed
}
