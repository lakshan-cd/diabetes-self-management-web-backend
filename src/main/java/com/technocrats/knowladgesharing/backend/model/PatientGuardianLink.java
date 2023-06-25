package com.technocrats.knowladgesharing.backend.model;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "patient_guardian_link")
public class PatientGuardianLink {
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PatientGuardianLink_generator")
//    private Long id;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PatientGuardianLink_generator")
    @Column(name = "g_id")
    private Long gId;

    @Column(name = "p_id")
    private Long pId;


    // Add constructors, getters, and setters as needed
}
