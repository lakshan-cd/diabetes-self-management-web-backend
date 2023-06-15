package com.technocrats.knowladgesharing.backend.controller;

import com.technocrats.knowladgesharing.backend.model.KInformation;
import com.technocrats.knowladgesharing.backend.service.CategoryCount;
import com.technocrats.knowladgesharing.backend.service.KInformationRequestObject;
import com.technocrats.knowladgesharing.backend.service.KInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//@CrossOrigin({"http:///192.168.8.103", "http://localhost:3000"})
@CrossOrigin("*")
//@CrossOrigin("http://localhost:3000")
//@RequestMapping("/kinformation")
public class KInformationController {

    @Autowired
    private KInformationService kInformationService;

    @GetMapping("/getAllKInformation")
    public List<KInformation> getAllKInformation(){
        return kInformationService.getAllKInformation();
    }


//    @GetMapping("/getKInformation/{catergory}")
//    public List<KInformation> getInformationByCategory(@PathVariable String catergory) {
//        return kInformationService.findByCategory(catergory);
//    }


    @GetMapping("/getKInformationByCategory/{catergory}")
    public List<KInformation> getKInformationByCategory(@PathVariable String catergory){
        return kInformationService.getKInformationByCategory(catergory);
    }

    @GetMapping("/getKInformationById/{id}")
    public KInformation getKInformationByCategory(@PathVariable Long id){
//        return kInformationService.getKInformationById(id);
        return kInformationService.getKInformationById(id);
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

    @PutMapping("/updateKInformation/{id}")
    public KInformation updateKInformation(@PathVariable Long id, @RequestBody KInformationRequestObject kInformationRequestObject){
        KInformation ki = kInformationService.getKInformationById(id);
        ki.setCatergory(kInformationRequestObject.getCatergory());
        ki.setDescription(kInformationRequestObject.getDescription());
        ki.setV_url(kInformationRequestObject.getV_url());
        ki.setImg_url(kInformationRequestObject.getImg_url());
        ki.setTitle(kInformationRequestObject.getTitle());
        return kInformationService.addKInformation(ki);
    }

    @DeleteMapping("/deleteKInformationById/{id}")
    public void deleteKInformationById(@PathVariable Long id) {
        kInformationService.deleteKInformationById(id);
    }


//    get the table post count acording to month
    @GetMapping("/countByMonth")
    public List<Object[]> getPostCountByMonth() {
        return kInformationService.getPostCountByMonth();
    }


//get count according to information type
    @GetMapping("/getCount")
    public ResponseEntity<List<Object[]>> getCountByCategory() {
        List<Object[]> countByCategory = kInformationService.getCountByCategory();
        return ResponseEntity.ok(countByCategory);
    }
}
