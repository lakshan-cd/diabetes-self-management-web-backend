package com.technocrats.knowladgesharing.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "dietplans")
public class DietPlans {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "dietplans_generator")
    private long did;
    @Lob
    @Column(name = "d_title")
    private String d_title;
    @Lob
    @Column
    private String d_description;
    @Lob
    @Column
    private String d_imglink;
    @Column(name = "created_date")
    @CreationTimestamp
    private LocalDateTime createdDate;


//    @ManyToOne(fetch = FetchType.LAZY , optional = false)
//    @JoinColumn(name = "admin_id" , nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
//    private Admin admin;




}
