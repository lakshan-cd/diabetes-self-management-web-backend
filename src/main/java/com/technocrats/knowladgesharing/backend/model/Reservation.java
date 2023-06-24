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
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "reservation_generator")
    private Long r_id;
    private String p_name;
    private int phone_no;
    private String r_type;
    private String date;
    private String time;
    private Long p_id;
    private Long d_id;
    private String isremove;
}
