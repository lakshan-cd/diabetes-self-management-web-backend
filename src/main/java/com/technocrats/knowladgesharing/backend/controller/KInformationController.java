package com.technocrats.knowladgesharing.backend.controller;

import com.technocrats.knowladgesharing.backend.model.KInformation;
import com.technocrats.knowladgesharing.backend.service.KInformationRequestObject;
import com.technocrats.knowladgesharing.backend.service.KInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://192.168.8.200")
//@RequestMapping("/kinformation")
public class KInformationController {

    @Autowired
    private KInformationService kInformationService;

    @GetMapping("/getAllKInformation")
    public List<KInformation> getAllKInformation(){
        return kInformationService.getAllKInformation();
    }
    @PostMapping("/addKInformation")
    public KInformation addKInformation(@RequestBody KInformationRequestObject kInformationRequestObject){
        KInformation ki = new KInformation();
        ki.setCatergory(kInformationRequestObject.getCatergory());
        ki.setDescription(kInformationRequestObject.getDescription());
        ki.setV_url(kInformationRequestObject.getV_url());
        ki.setImg_url(kInformationRequestObject.getImg_url());
        ki.setTitle(kInformationRequestObject.getTitle());
        return kInformationService.addKInformation(ki);

    }
}
