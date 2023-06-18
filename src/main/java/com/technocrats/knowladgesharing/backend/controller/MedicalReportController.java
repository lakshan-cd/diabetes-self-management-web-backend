package com.technocrats.knowladgesharing.backend.controller;

import com.technocrats.knowladgesharing.backend.dto.MedicalReportInputRequestObject;
import com.technocrats.knowladgesharing.backend.model.MedicalReport;
import com.technocrats.knowladgesharing.backend.service.MedicalService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class MedicalReportController {

    @Autowired
    private MedicalService medicalService;

    @PostMapping("/addNewReport")
    public ResponseEntity<MedicalReport> addNewReport(@RequestBody MedicalReportInputRequestObject medicalReportInputRequestObject) {
        MedicalReport medicalReport = new MedicalReport();
        BeanUtils.copyProperties(medicalReportInputRequestObject, medicalReport);

        MedicalReport saveMedicalReport = medicalService.addNewReport(medicalReport);
        return new ResponseEntity<>(saveMedicalReport, HttpStatus.CREATED);

    }
}
