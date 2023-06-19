package com.technocrats.knowladgesharing.backend.service;


import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@SuperBuilder
public class VerificationRequest {
    private String email;
    private String otp;

}
