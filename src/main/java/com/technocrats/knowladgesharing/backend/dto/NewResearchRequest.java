package com.technocrats.knowladgesharing.backend.dto;

import com.technocrats.knowladgesharing.backend.model.NewsReaserch;
import com.technocrats.knowladgesharing.backend.repository.NewsResearchRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NewResearchRequest {
    private NewsReaserch newsReaserch;
}
