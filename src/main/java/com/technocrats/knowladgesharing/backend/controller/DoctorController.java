package com.technocrats.knowladgesharing.backend.controller;

import com.technocrats.knowladgesharing.backend.dto.DoctorInputRequestObject;
import com.technocrats.knowladgesharing.backend.model.Doctor;
import com.technocrats.knowladgesharing.backend.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://192.168.8.101")
//@CrossOrigin("http://localhost:3000")

public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    //add data
    @PostMapping("/adddoctorinformation")
    public Doctor addDoctorInformation (@RequestBody DoctorInputRequestObject doctorInputRequestObject){
        Doctor d = new Doctor();
        d.setUsername(doctorInputRequestObject.getUsername());
        d.setPassword(doctorInputRequestObject.getPassword());
        d.setEmail(doctorInputRequestObject.getEmail());
        d.setFname(doctorInputRequestObject.getFname());
        d.setLname(doctorInputRequestObject.getLname());
        d.setTelephoneno(doctorInputRequestObject.getTelephoneno());
        d.setHNo(doctorInputRequestObject.getHNo());
        d.setA_date(doctorInputRequestObject.getA_date());
        d.setA_time(doctorInputRequestObject.getA_time());
        d.setImg_url(doctorInputRequestObject.getImg_url());
        return doctorService.addDoctorInfromation(d);

    }

    //get all the dat of doctors
    @GetMapping("/getdoctordata")
    public List<Doctor> getDocotorData(){
        return doctorService.getDoctorData();
    }

    //get by id
    @GetMapping("getdoctordatabyid/{id}")
    public Doctor getDoctorDataById (@PathVariable Long id){
        return doctorService.getDoctorDataById(id);
    }

    //get acording to catergory
    @GetMapping("getdataaordingtocatergory/{catergory}")
    public List<Doctor> getDoctorDataAcordingtoCatergoty(@PathVariable String catergory){
        return doctorService.getDataAcordingToCatergory(catergory);
    }

}
