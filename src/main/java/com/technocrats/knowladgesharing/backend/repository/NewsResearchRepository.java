package com.technocrats.knowladgesharing.backend.repository;

import com.technocrats.knowladgesharing.backend.model.NewsReaserch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NewsResearchRepository extends JpaRepository<NewsReaserch , Long> {
//    @Query("SELECT nr_description,nr_imglink FROM NewsReaserch ORDER BY did DESC LIMIT 5")
//    List<NewsReaserch> findLatest10();
}
