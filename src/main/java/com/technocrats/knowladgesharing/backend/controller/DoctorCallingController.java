package com.technocrats.knowladgesharing.backend.controller;

import com.technocrats.knowladgesharing.backend.dto.DoctorCallingDto;
import com.technocrats.knowladgesharing.backend.dto.MedicalReportInputRequestObject;
import com.technocrats.knowladgesharing.backend.model.DoctorCalling;
import com.technocrats.knowladgesharing.backend.model.MedicalReport;
import com.technocrats.knowladgesharing.backend.service.DoctorCallingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("api/doctor")
public class DoctorCallingController {

    private final DoctorCallingService doctorCallingService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DoctorCallingDto> getDoctors(){
        return this.doctorCallingService.getDoctors();
    }

    @PostMapping("/addNewDoctorForCalling")
    public ResponseEntity<DoctorCalling> addNewDoctorForCalling(@RequestBody DoctorCallingDto doctorCallingDto) {
        DoctorCalling doctorCalling = new DoctorCalling();
        BeanUtils.copyProperties(doctorCallingDto, doctorCalling);

        DoctorCalling saveDoctorsForCalling = doctorCallingService.addNewDoctorForCalling(doctorCalling);
        return new ResponseEntity<>(saveDoctorsForCalling, HttpStatus.CREATED);
    }
}
