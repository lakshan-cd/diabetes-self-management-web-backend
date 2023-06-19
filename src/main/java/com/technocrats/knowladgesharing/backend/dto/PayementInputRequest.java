package com.technocrats.knowladgesharing.backend.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@SuperBuilder
public class PayementInputRequest {

    float amount;
    int pid;
}
