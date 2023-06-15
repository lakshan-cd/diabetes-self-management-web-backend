package com.technocrats.knowladgesharing.backend.controller;

import com.technocrats.knowladgesharing.backend.dto.NutritionistAvailabilityRequestObject;
import com.technocrats.knowladgesharing.backend.model.NutritionistAvailability;
import com.technocrats.knowladgesharing.backend.service.NutritionistAvailabilityService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
//@CrossOrigin("http://192.168.8.101")

public class NutritionistAvailabilityController {
    @Autowired
    private NutritionistAvailabilityService nutritionistAvailabilityService;


    @PostMapping("/nutritionist-availabilities")
    public NutritionistAvailability addNutritionistAvailability(@RequestBody NutritionistAvailabilityRequestObject nutritionistAvailabilityRequestObject) {
        NutritionistAvailability na = new NutritionistAvailability();
        na.setA_date(nutritionistAvailabilityRequestObject.getA_date());
        na.setA_time(nutritionistAvailabilityRequestObject.getA_time());
        return nutritionistAvailabilityService.addNutritionistAvailability(na);
    }

}
