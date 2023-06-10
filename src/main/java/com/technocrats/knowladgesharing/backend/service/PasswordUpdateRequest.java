package com.technocrats.knowladgesharing.backend.service;

import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@SuperBuilder
public class PasswordUpdateRequest {
    private String currentPassword;
    private String newPassword;
}
