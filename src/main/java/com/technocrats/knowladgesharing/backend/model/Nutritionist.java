package com.technocrats.knowladgesharing.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Nutritionist {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "nutritionist_generator")
    private Long nid;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "fname")
    private String fname;
    @Column(name = "lname")
    private String lname;
    @Column(name = "telephone")
    private int telephoneno;
    private String city;
    private String street;
    private String hNo;
    private Date a_date;
    private String a_time;

//    @OneToMany(targetEntity = Workouts.class , cascade = CascadeType.ALL)
//    @JoinColumn(name ="nt_id_fk", referencedColumnName = "nid")
//    private List<Workouts> workouts;
//
//    @OneToMany(targetEntity = DietPlans.class , cascade = CascadeType.ALL)
//    @JoinColumn(name ="nt_id_fk", referencedColumnName = "nid")
//    private List<DietPlans> dietPlans;
//
//    @OneToMany(targetEntity = NewsReaserch.class , cascade = CascadeType.ALL)
//    @JoinColumn(name ="nt_id_fk", referencedColumnName = "nid")
//    private List<NewsReaserch> newsResearch;

}
