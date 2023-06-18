package com.technocrats.knowladgesharing.backend.service;

import com.technocrats.knowladgesharing.backend.dto.DoctorInputRequestObject;
import com.technocrats.knowladgesharing.backend.dto.MedicalReportInputRequestObject;
import com.technocrats.knowladgesharing.backend.model.Doctor;
import com.technocrats.knowladgesharing.backend.model.MedicalReport;
import com.technocrats.knowladgesharing.backend.repository.MedicalReportRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class MedicalService {

    @Autowired
    private MedicalReportRepository medicalReportRepository;


    public MedicalReport addNewReport(MedicalReport medicalReport) {
        return medicalReportRepository.save(medicalReport);
    }
}
