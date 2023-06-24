package com.technocrats.knowladgesharing.backend.service;

import com.technocrats.knowladgesharing.backend.exception.ResourceNotFoundException;
import com.technocrats.knowladgesharing.backend.model.Doctor;
import com.technocrats.knowladgesharing.backend.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    //add doctors
    public Doctor addDoctorInfromation (Doctor doctor){
        return doctorRepository.save(doctor);

    }

    //to get all the dat of doctors
    public List<Doctor> getDoctorData(){
        return doctorRepository.findAll();
    }
    //get by id
    public Doctor getDoctorDataById (Long id){
        return doctorRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("User" , "id" , id));

    }

    //get data acording to catergory
//    public List<Doctor> getDataAcordingToCatergory( String catergory){
//        return doctorRepository.findByCatergory(catergory);
//    }



}
