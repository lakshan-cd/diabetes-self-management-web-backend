package com.technocrats.knowladgesharing.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
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
    private String username;
    private String password;
    private String email;
    private String fname;
    private String lname;
    private String telephoneno;

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
