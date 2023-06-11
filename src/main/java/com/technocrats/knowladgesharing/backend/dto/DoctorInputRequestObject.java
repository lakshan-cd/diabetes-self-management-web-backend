package com.technocrats.knowladgesharing.backend.dto;


import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@SuperBuilder
public class DoctorInputRequestObject {

    private String username;
    private String password;
    private String email;
    private String fname;
    private String lname;
    private int telephoneno;
    private String hNo;
    private String a_date;
    private String a_time;
    private String img_url;
}
