package com.technocrats.knowladgesharing.backend.service;

import com.technocrats.knowladgesharing.backend.exception.ResourceNotFoundException;
import com.technocrats.knowladgesharing.backend.model.Doctor;
import com.technocrats.knowladgesharing.backend.model.Nutritionist;
import com.technocrats.knowladgesharing.backend.repository.NutritionistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NutritionistService {
    @Autowired
    private NutritionistRepository nutritionistRepository;

    public Nutritionist addNutritionistInformation (Nutritionist nutritionist){
        return nutritionistRepository.save(nutritionist);

    }
    public Nutritionist getNutritionistDataById (Long id){
        return nutritionistRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Doctor" , "id" , id));

    }

    //get all nutritionist

    public List<Nutritionist> getALlNutritionists (){
        return nutritionistRepository.findAll();
    }
}
