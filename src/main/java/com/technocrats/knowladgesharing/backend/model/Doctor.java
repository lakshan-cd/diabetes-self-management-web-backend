package com.technocrats.knowladgesharing.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "doctor_generator")
    private Long did;
//    @Column(name = "username")
//    private String username;
//    @Column(name = "password")
//    private String password;
//    @Column(name = "email")
//    private String email;
//    @Column(name = "fname")
//    private String fname;
//    @Column(name = "lname")
//    private String lname;
//    @Column(name = "telephone")
//    private int telephoneno;
//    private String hNo;
//    private String a_date;
//    private String a_time;
//    private String img_url;

    @Column(name = "description")
    private String description;
//    private int p_rate;

    @ElementCollection
    private List<String> p_rate = new ArrayList<>();

    @ElementCollection
    private List<String> a_date = new ArrayList<>();

    @ElementCollection
    private List<String> a_time = new ArrayList<>();

    @Column(name = "email")
    private String email;
    @Column(name = "fname")
    private String fname;
    @Column(name = "lname")
    private String lname;
    @Column(name = "telephone")
    private int telephoneno;
    private String hNo;
    private String img_url;
    private String type;

}
