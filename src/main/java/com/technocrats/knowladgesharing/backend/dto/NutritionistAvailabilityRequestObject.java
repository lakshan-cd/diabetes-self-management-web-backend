package com.technocrats.knowladgesharing.backend.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@SuperBuilder
public class NutritionistAvailabilityRequestObject {
//    private String description;
//    private int p_rate;
    private LocalDate a_date;
    private String a_time;
}
