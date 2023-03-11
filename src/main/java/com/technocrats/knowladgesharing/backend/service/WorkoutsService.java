package com.technocrats.knowladgesharing.backend.service;

import com.technocrats.knowladgesharing.backend.exception.ResourceNotFoundException;
import com.technocrats.knowladgesharing.backend.model.DietPlans;
import com.technocrats.knowladgesharing.backend.model.NewsReaserch;
import com.technocrats.knowladgesharing.backend.model.Workouts;
import com.technocrats.knowladgesharing.backend.repository.WorkoutsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutsService {

    @Autowired
    private WorkoutsRepository workoutsRepository;

    public List<Workouts> getALlWorkouts(){
        return workoutsRepository.findAll();
    }

    public Workouts addWorkouts(Workouts workouts) {
        return workoutsRepository.save(workouts);
    }

    public Workouts getWorkoutsDataById(Long id) {
        return workoutsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }
}
