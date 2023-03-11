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
@Table(name = "newsandreaserch")
public class NewsReaserch {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "newsandreaserch_generator")
    private long did;
    @Lob
    @Column(name = "nr_title")
    private String d_title;
    @Lob
    @Column
    private String nr_description;
    @Lob
    @Column
    private String nr_imglink;
    @Column(name = "created_date")
    @CreationTimestamp
    private LocalDateTime createdDate;

//    @ManyToOne(fetch = FetchType.LAZY , optional = false)
//    @JoinColumn(name = "admin_id" , nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
//    private Admin admin;
}
