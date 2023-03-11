package com.technocrats.knowladgesharing.backend.dto;

import com.technocrats.knowladgesharing.backend.model.Workouts;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WorkoutsRequest {
    private Workouts workouts;
}
