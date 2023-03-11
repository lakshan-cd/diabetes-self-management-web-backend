package com.technocrats.knowladgesharing.backend.controller;

import com.technocrats.knowladgesharing.backend.dto.WorkoutsRequest;
import com.technocrats.knowladgesharing.backend.model.NewsReaserch;
import com.technocrats.knowladgesharing.backend.model.Workouts;
import com.technocrats.knowladgesharing.backend.repository.WorkoutsRepository;
import com.technocrats.knowladgesharing.backend.service.WorkoutsRequestObject;
import com.technocrats.knowladgesharing.backend.service.WorkoutsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class WorkoutsController {

    @Autowired
    private WorkoutsService workoutsService;

    @GetMapping("/getworkoutsdata")
    public List<Workouts> getALlWorkouts(){
        return workoutsService.getALlWorkouts();
    }

    @GetMapping("/getworkoutsdatabyid/{id}")
    public Workouts getworkoutsdatabyid(@PathVariable Long id){
        return workoutsService.getWorkoutsDataById(id);
    }




    @PostMapping("/addworkouts")
    public Workouts addWorkouts(@RequestBody WorkoutsRequestObject workoutsRequestObject) {
        Workouts wo = new Workouts();
        wo.setD_title(workoutsRequestObject.getW_title());
        wo.setW_description(workoutsRequestObject.getW_description());
        wo.setW_imglink(workoutsRequestObject.getW_imglink());
        return workoutsService.addWorkouts(wo);
    }

//    @Autowired
//    private WorkoutsRepository workoutsRepository;
//
//    @PostMapping("/addworkouts")
//    public Workouts addData(@RequestBody WorkoutsRequest request){
//        return workoutsRepository.save(request.getWorkouts());
//
//    }
//    @GetMapping("/getworkoutsdata")
//    public List<Workouts>findData(){
//        return workoutsRepository.findAll();
//    }


}
