package com.technocrats.knowladgesharing.backend.service;

import com.technocrats.knowladgesharing.backend.exception.ResourceNotFoundException;
import com.technocrats.knowladgesharing.backend.model.KInformation;
import com.technocrats.knowladgesharing.backend.repository.KInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KInformationService  {

    @Autowired
    private KInformationRepository kInformationRepository;

//    @Autowired
//    private KInformationServiceRepo kInformationRepositoryRepo;

    public KInformation addKInformation(KInformation kInformation){

        return kInformationRepository.save(kInformation);
    }


//    @Override
//    public List<KInformation> findByCategory(String catergory) {
//        return kInformationRepositoryRepo.findByCategory(catergory);
//    }

    public List<KInformation> getKInformationByCategory(String catergory){
        return kInformationRepository.findByCatergory(catergory);
    }

    public KInformation getKInformationById(Long id) {
        return kInformationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }

    public List<KInformation> getAllKInformation(){
        return kInformationRepository.findAll();
    }
    //Delete  dta acording to id
    public void deleteKInformationById(Long id) {
        kInformationRepository.deleteById(id);
    }

//    get count of post acording to month
//    @Override
    public List<Object[]> getPostCountByMonth() {
        return kInformationRepository.getPostCountByMonth();
    }


    //get count of all
    public List<Object[]> getCountByCategory() {
        return kInformationRepository.countByCategory();
    }
}
