package com.technocrats.knowladgesharing.backend.service;

import com.technocrats.knowladgesharing.backend.dto.DoctorCallingDto;
import com.technocrats.knowladgesharing.backend.model.DoctorCalling;

import java.util.List;

public interface DoctorCallingService {
    List<DoctorCallingDto> getDoctors();

    DoctorCalling addNewDoctorForCalling(DoctorCalling doctorCalling);
}
