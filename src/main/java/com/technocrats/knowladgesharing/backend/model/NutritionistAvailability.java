package com.technocrats.knowladgesharing.backend.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
//@Setter
@Entity
public class NutritionistAvailability {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "nutritionist_Availability_generator")
    private Long nutritionistAvailabilityId;

    @ManyToOne
    @JoinColumn(name = "nId")
    private Nutritionist nutritionist;

    private LocalDate a_date;
    private String a_time;

//    public Long getn_id() {
//        this.nutritionist = nutritionist;
//    }

//    public Long getNutritionistId() {
//    }

//    public Long getNutritionistId() {
//    }

//    public Long getNutritionistId() {
//
//    }
}
