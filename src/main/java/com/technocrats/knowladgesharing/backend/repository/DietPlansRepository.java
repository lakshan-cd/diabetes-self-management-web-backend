package com.technocrats.knowladgesharing.backend.repository;

import com.technocrats.knowladgesharing.backend.model.DietPlans;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DietPlansRepository extends JpaRepository<DietPlans , Long> {
}
