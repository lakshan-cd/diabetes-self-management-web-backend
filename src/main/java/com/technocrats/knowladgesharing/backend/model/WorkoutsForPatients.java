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
@Table(name = "workoutsforpatient")
public class WorkoutsForPatients {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "workouts_p_generator")
    private Long w_id;
    private String video_url;
    private String img_url;
    @Lob
    private String description;
}
