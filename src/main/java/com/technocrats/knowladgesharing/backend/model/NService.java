package com.technocrats.knowladgesharing.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "nservice")
public class NService {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "nutritionist_service_generator")
    private Long sid;
    private String catergory;
    private String img_url;
    private String v_url;
    private String description;
}
