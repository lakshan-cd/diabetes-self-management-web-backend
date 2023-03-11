package com.technocrats.knowladgesharing.backend.controller;


import com.technocrats.knowladgesharing.backend.dto.NurtritionistRequest;
import com.technocrats.knowladgesharing.backend.model.Nutritionist;
import com.technocrats.knowladgesharing.backend.repository.NutritionistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class NutritionistController {

    @Autowired
    private NutritionistRepository nutritionistRepository;

    @PostMapping("/addnutritionist")
    public Nutritionist addData(@RequestBody NurtritionistRequest request){

        return nutritionistRepository.save(request.getNutritionist());
    }

    @GetMapping("/getnutritionist")
    public List<Nutritionist> findData(){
        return nutritionistRepository.findAll();
    }
}
