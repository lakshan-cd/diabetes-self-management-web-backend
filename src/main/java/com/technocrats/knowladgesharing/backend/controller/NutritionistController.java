package com.technocrats.knowladgesharing.backend.controller;


import com.technocrats.knowladgesharing.backend.dto.DoctorInputRequestObject;
import com.technocrats.knowladgesharing.backend.dto.NurtritionistRequestObject;
import com.technocrats.knowladgesharing.backend.model.Doctor;
import com.technocrats.knowladgesharing.backend.model.Nutritionist;
import com.technocrats.knowladgesharing.backend.repository.NutritionistRepository;
import com.technocrats.knowladgesharing.backend.service.NutritionistService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class NutritionistController {
    @Autowired
    private NutritionistService nutritionistService;

//    @PostMapping("/addnutritionist")
//    public Nutritionist addData(@RequestBody NurtritionistRequestObject nurtritionistRequestObject){
//        Nutritionist n = new Nutritionist();
//        n.setDescription(nurtritionistRequestObject.getDescription());
//        n.setP_rate(nurtritionistRequestObject.getP_rate());
//        return nutritionistService.addNutritionistInformation(n);
//
//
//    }

//    @GetMapping("/getnutritionist")
//    public List<Nutritionist> findData(){
//        return nutritionistRepository.findAll();
//    }


    //////////////////////

    @PostMapping("/addnutritionist")
    public ResponseEntity<Nutritionist> createNutritionistTable(@RequestBody NurtritionistRequestObject nurtritionistRequestObject) {
        Nutritionist nutritionistTable = new Nutritionist();
        BeanUtils.copyProperties(nurtritionistRequestObject, nutritionistTable);

        Nutritionist savedNutritionistTable = nutritionistService.addNutritionistInformation(nutritionistTable);
        return new ResponseEntity<>(savedNutritionistTable, HttpStatus.CREATED);

    }

    //find nutritinist by id
    @GetMapping("/getnutritionist/{id}")
    public ResponseEntity<Nutritionist> getNutritionistTable(@PathVariable Long id) {
        Nutritionist nutritionistTable = nutritionistService.getNutritionistDataById(id);
        if (nutritionistTable == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(nutritionistTable, HttpStatus.OK);
    }

    //find all nutrionists

    @GetMapping("/getallnutritionist")

    public List<Nutritionist> getALlNutritionist(){
        return nutritionistService.getALlNutritionists();
    }

    //update Nutritionist data
    @PutMapping("/updateNutritionist/{id}")
    public ResponseEntity<Nutritionist> updateNUtritionistById(@PathVariable Long id, @RequestBody NurtritionistRequestObject nurtritionistRequestObject ) {
        Nutritionist nutritionist = nutritionistService.getNutritionistDataById(id);
        nutritionist.setA_date(nurtritionistRequestObject.getA_date());
        nutritionist.setA_time(nurtritionistRequestObject.getA_time());

        Nutritionist updateNutritionist = nutritionistService.addNutritionistInformation(nutritionist);
        return new ResponseEntity<>(updateNutritionist, HttpStatus.CREATED);
    }
}
