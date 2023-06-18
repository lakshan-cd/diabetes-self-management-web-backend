package com.technocrats.knowladgesharing.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "medicalreports")
public class MedicalReport {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "medical_report_generator")
    private Long rid;
    private String description;
    private String type;
    @ElementCollection
    private List<String> reportlink = new ArrayList<>();
    private int pid;
    private int did;
    private int nid;

}
