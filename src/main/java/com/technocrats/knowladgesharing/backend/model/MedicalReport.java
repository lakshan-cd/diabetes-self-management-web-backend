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
@Table(name = "medicalreports")
public class MedicalReport {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "medical_report_generator")
    private Long r_id;
    private String description;
    private String type;
}
