package com.technocrats.knowladgesharing.backend.service;

import com.technocrats.knowladgesharing.backend.dto.DoctorCallingDto;
import com.technocrats.knowladgesharing.backend.model.DoctorCalling;
import com.technocrats.knowladgesharing.backend.repository.DoctorCallingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorCallingserviceImpl implements DoctorCallingService {

    private final DoctorCallingRepository doctorCallingRepository;

    @Override
    public List<DoctorCallingDto> getDoctors(){
        return this.doctorCallingRepository.findAll()
                .stream()
                .map(DoctorCallingDto::new)
                .collect(Collectors.toList());
    }

    public DoctorCalling addNewDoctorForCalling (DoctorCalling doctorCalling){
        return doctorCallingRepository.save(doctorCalling);

    }
}
