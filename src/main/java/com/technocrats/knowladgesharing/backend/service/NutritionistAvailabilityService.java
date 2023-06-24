package com.technocrats.knowladgesharing.backend.service;

import com.technocrats.knowladgesharing.backend.model.Nutritionist;
import com.technocrats.knowladgesharing.backend.model.NutritionistAvailability;
import com.technocrats.knowladgesharing.backend.repository.NutritionistAvailabilityRepository;
import com.technocrats.knowladgesharing.backend.repository.NutritionistRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
public class NutritionistAvailabilityService {
    private NutritionistAvailabilityRepository nutritionistAvailabilityRepository;
    private NutritionistRepository nutritionistRepository;

    public NutritionistAvailabilityService(NutritionistAvailabilityRepository nutritionistAvailabilityRepository, NutritionistRepository nutritionistRepository) {
        this.nutritionistAvailabilityRepository = nutritionistAvailabilityRepository;
        this.nutritionistRepository = nutritionistRepository;
    }

    public NutritionistAvailability addNutritionistAvailability(NutritionistAvailability nutritionistAvailability) {
        // Set the relationship between NutritionistAvailability and Nutritionist
        // Assuming you have a nutritionistId property in the NutritionistAvailability object

        Nutritionist nutritionist = nutritionistRepository.findById(nutritionistAvailability.getNutritionistAvailabilityId()).orElseThrow(() -> new RuntimeException ("Nutritionist not found"));
        nutritionistAvailability.setNutritionist(nutritionist);

        return nutritionistAvailabilityRepository.save(nutritionistAvailability);
    }
}
