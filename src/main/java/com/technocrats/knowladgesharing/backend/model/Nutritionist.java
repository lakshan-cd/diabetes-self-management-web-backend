package com.technocrats.knowladgesharing.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
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
    private Long nId;
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


//    @OneToOne
//    @JoinColumn(name = "uid")
//    private User user;

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
