package com.technocrats.knowladgesharing.backend.controller;

import com.technocrats.knowladgesharing.backend.dto.DietPlanRequest;
import com.technocrats.knowladgesharing.backend.model.DietPlans;

import com.technocrats.knowladgesharing.backend.repository.DietPlansRepository;
import com.technocrats.knowladgesharing.backend.service.DietPlanRequestObject;
import com.technocrats.knowladgesharing.backend.service.DietPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")

public class DietPlansController {

    @Autowired
    private DietPlanService dietPlanService;

    @GetMapping("/getdietplan")
    public List<DietPlans> getAllDietPlans(){
        return dietPlanService.getAllDietPlans();
    }

    @GetMapping("/getdietplanbyid/{id}")
    public DietPlans getdietplanbyid(@PathVariable Long id){
        return dietPlanService.getDietPlansDataById(id);
    }


    @PostMapping("/adddietplans")
    public DietPlans addDietPlan(@RequestBody DietPlanRequestObject dietPlanRequestObject) {
        DietPlans dt = new DietPlans();
        dt.setD_title(dietPlanRequestObject.getD_title());
        dt.setD_description(dietPlanRequestObject.getDescription());
        dt.setD_imglink(dietPlanRequestObject.getImg_link());
        return dietPlanService.addDietPlan(dt);
    }





//    @Autowired
//    private DietPlansRepository dietPlansRepository;
//
//    @PostMapping("/adddietplans")
//    public DietPlans addData(@RequestBody DietPlanRequestObject request){
//        DietPlans dt = new DietPlans();
//        dt.setD_description(request.getDescription());
//        dt.setD_imglink(request.getImg_link());
//
//
//
//        return dietPlansRepository.save(dt);
//
//
//    }
//    @GetMapping("/getdietplan")
//    public List<DietPlans>findData(){
//        return dietPlansRepository.findAll();
//    }

}
