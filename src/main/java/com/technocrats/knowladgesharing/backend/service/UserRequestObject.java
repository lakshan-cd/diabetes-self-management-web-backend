package com.technocrats.knowladgesharing.backend.service;

import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@SuperBuilder
public class UserRequestObject {
    String firstname;
    String lastname;
    String NIC;
    String email;
    String password;
    String user_type;
}
