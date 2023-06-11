package com.technocrats.knowladgesharing.backend.service;

import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@SuperBuilder
public class ReservationRequestObject {
     String p_name;
     int phone_no;
     String r_type;
     String date;
     String time;


}
