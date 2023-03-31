package com.technocrats.knowladgesharing.backend.service;

import com.technocrats.knowladgesharing.backend.model.KInformation;
import com.technocrats.knowladgesharing.backend.repository.KInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KInformationService {

    @Autowired
    private KInformationRepository kInformationRepository;

    public KInformation addKInformation(KInformation kInformation){

        return kInformationRepository.save(kInformation);
    }

    public List<KInformation> getAllKInformation(){
        return kInformationRepository.findAll();
    }
}
