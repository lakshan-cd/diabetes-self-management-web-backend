package com.technocrats.knowladgesharing.backend.repository;

import com.technocrats.knowladgesharing.backend.model.KInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KInformationRepository extends JpaRepository<KInformation , Long> {
}
