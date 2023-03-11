package com.technocrats.knowladgesharing.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "workouts")
public class Workouts {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "workouts_generator")
    private long wid;
    @Lob
    @Column(name = "w_title")
    private String d_title;
    @Lob
    @Column
    private String w_description;
    @Lob
    @Column
    private String w_imglink;
    @Column(name = "created_date")
    @CreationTimestamp
    private LocalDateTime createdDate;
//    @ManyToOne(fetch = FetchType.LAZY , optional = false)
//    @JoinColumn(name = "admin_id" , nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
//    private Admin admin;


}
