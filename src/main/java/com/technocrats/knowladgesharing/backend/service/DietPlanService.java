package com.technocrats.knowladgesharing.backend.service;

import com.technocrats.knowladgesharing.backend.exception.ResourceNotFoundException;
import com.technocrats.knowladgesharing.backend.model.DietPlans;
import com.technocrats.knowladgesharing.backend.model.NewsReaserch;
import com.technocrats.knowladgesharing.backend.repository.DietPlansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DietPlanService {

    @Autowired
    private DietPlansRepository dietPlansRepository;

    public List<DietPlans> getAllDietPlans(){
        return dietPlansRepository.findAll();
    }

    public DietPlans addDietPlan(DietPlans dietPlans) {
        return dietPlansRepository.save(dietPlans);
    }

    public DietPlans getDietPlansDataById(Long id) {
        return dietPlansRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }
}
