package com.technocrats.knowladgesharing.backend.repository;

import com.technocrats.knowladgesharing.backend.model.DoctorCalling;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorCallingRepository extends JpaRepository<DoctorCalling , Long> {
}
