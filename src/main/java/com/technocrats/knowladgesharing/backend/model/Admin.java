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
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "admin_generator")
    private Long aid;
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

//    @OneToMany(targetEntity = KInformation.class , cascade = CascadeType.ALL)
//    @JoinColumn(name ="admin_id_fk", referencedColumnName = "aid")
//    private List<KInformation> kInformationList;

//    @OneToMany(targetEntity = KInformation.class , cascade = CascadeType.ALL)
//    @JoinColumn(name ="admin_id_fk", referencedColumnName = "aid")
//    private List<KInformation> kInformations;


//
//    @OneToMany(targetEntity = DietPlans.class , cascade = CascadeType.ALL)
//    @JoinColumn(name ="admin_id_fk", referencedColumnName = "aid")
//    private List<DietPlans> dietPlans;
//
//    @OneToMany(targetEntity = NewsReaserch.class , cascade = CascadeType.ALL)
//    @JoinColumn(name ="admin_id_fk", referencedColumnName = "aid")
//    private List<NewsReaserch> newsResearch;
//    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)



}
