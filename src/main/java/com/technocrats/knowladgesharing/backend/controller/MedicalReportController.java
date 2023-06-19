package com.technocrats.knowladgesharing.backend.controller;

import com.technocrats.knowladgesharing.backend.dto.MedicalReportDTO;
import com.technocrats.knowladgesharing.backend.dto.MedicalReportInputRequestObject;
import com.technocrats.knowladgesharing.backend.model.MedicalReport;
import com.technocrats.knowladgesharing.backend.service.MedicalService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    //make get mapping by pid and did
    // pid => Patient ID
    // did => doctor ID
    @GetMapping("/medicalReports/did/{pid}/{did}")
    public ResponseEntity<List<MedicalReport>> getMedicalReportsByPidAndDid(
            @PathVariable int pid,
            @PathVariable int did
    ) {
        ResponseEntity<List<MedicalReport>> medicalReports = medicalService.getReportsByPidAndDid(pid, did);
        return ResponseEntity.ok(medicalReports.getBody());
    }

    private MedicalReportDTO convertToDTO(MedicalReport medicalReport) {
        MedicalReportDTO dto = new MedicalReportDTO();
        dto.setRid(medicalReport.getRid());
        dto.setDescription(medicalReport.getDescription());
        dto.setType(medicalReport.getType());
        dto.setReportlink(medicalReport.getReportlink());
        dto.setPid(medicalReport.getPid());
        dto.setDid(medicalReport.getDid());
        dto.setNid(medicalReport.getNid());
        return dto;
    }

// get mapping by pid and nid...........
    // pid => patient ID
    // nid => nutritionist ID
    @GetMapping("/medicalReports/nid/{pid}/{nid}")
    public ResponseEntity<List<MedicalReport>> getMedicalReportsByPidAndNid(
            @PathVariable int pid,
            @PathVariable int nid
    ) {
        ResponseEntity<List<MedicalReport>> medicalReports = medicalService.getReportsByPidAndNid(pid, nid);
        return ResponseEntity.ok(medicalReports.getBody());
    }


    private MedicalReportDTO convertToDTO1(MedicalReport medicalReport) {
        MedicalReportDTO dto = new MedicalReportDTO();
        dto.setRid(medicalReport.getRid());
        dto.setDescription(medicalReport.getDescription());
        dto.setType(medicalReport.getType());
        dto.setReportlink(medicalReport.getReportlink());
        dto.setPid(medicalReport.getPid());
        dto.setDid(medicalReport.getDid());
        dto.setNid(medicalReport.getNid());
        return dto;
    }



}


