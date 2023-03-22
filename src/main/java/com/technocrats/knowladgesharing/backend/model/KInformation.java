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
@Table(name = "kinformation")
public class KInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "knowladge_sharing_generator")
    private Long kid;
    private String catergory;
    private String img_url;
    private String v_url;
    private String description;
}
