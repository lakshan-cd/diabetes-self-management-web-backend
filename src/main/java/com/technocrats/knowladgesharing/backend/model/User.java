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
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "User_generator")
    private Long uid;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name ="NIC")
    private String NIC;
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    @Column(name = "password",nullable = false)
    private String password;
    @Column(name = "user_type")
    private String user_type;
    @Column(name ="profilePictureUrl")
    private String profilePictureUrl;

}
