package com.technocrats.knowladgesharing.backend.controller;

import com.technocrats.knowladgesharing.backend.model.NewsReaserch;
import com.technocrats.knowladgesharing.backend.service.NewResearchService;
import com.technocrats.knowladgesharing.backend.service.NewsReaserchRequestObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class NewsResearchController {

    @Autowired
    private NewResearchService newResearchService;

//    private NewsResearchRepository newsResearchRepository;

//    @PostMapping("/addnewsresearch")
//    public NewsReaserch addData(@RequestBody NewResearchRequest request){
//        return newsResearchRepository.save(request.getNewsReaserch());
//
//    }


    @GetMapping("/gettingnewsreasearchdata")
    public List<NewsReaserch> getAllData(){
        return newResearchService.getALlData();
    }

    @GetMapping("/gettingnewsreasearchdata/{id}")
    public NewsReaserch getNewsResearchById(@PathVariable Long id) {
        return newResearchService.getNewsResearchDataById(id);
    }

//    @GetMapping("/gettingnewsreasearchdata5")
//    public List<NewsReaserch> getAllData5(){
//        return newResearchService.getLatest10();
//    }

    @PostMapping("/addnewsresearch")
    public NewsReaserch addNewsResearch(@RequestBody NewsReaserchRequestObject newsReaserchRequestObject) {
        NewsReaserch nr = new NewsReaserch();
        nr.setD_title(newsReaserchRequestObject.getNr_title());
        nr.setNr_description(newsReaserchRequestObject.getNr_description());
        nr.setNr_imglink(newsReaserchRequestObject.getNr_imglink());
        return newResearchService.addNewsResearch(nr);
    }
//    public List<NewsReaserch> findData(){
//        return newsResearchRepository.findAll();
//    }
}
