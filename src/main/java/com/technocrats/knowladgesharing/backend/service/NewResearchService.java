package com.technocrats.knowladgesharing.backend.service;

import com.technocrats.knowladgesharing.backend.exception.ResourceNotFoundException;
import com.technocrats.knowladgesharing.backend.model.NewsReaserch;
import com.technocrats.knowladgesharing.backend.repository.NewsResearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewResearchService {

    @Autowired
    private NewsResearchRepository newsResearchRepository;

    public List<NewsReaserch> getALlData(){
        return newsResearchRepository.findAll();
//        return @Query("SELECT * FROM TableName ORDER BY id DESC LIMIT 5");
//        List<Entity> findLatest10();
    }

//    public List<NewsReaserch> getLatest10() {
//        return newsResearchRepository.findLatest10();
//    }

    public NewsReaserch addNewsResearch(NewsReaserch newsReaserch) {
        return newsResearchRepository.save(newsReaserch);
    }

    //retrive data by id
    public NewsReaserch getNewsResearchDataById(Long id) {
        return newsResearchRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }



}
