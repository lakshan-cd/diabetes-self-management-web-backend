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
@Table(name = "kinformation")
public class KInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "knowladge_sharing_generator")
    private Long kid;
    private String title;
    private String catergory;
    @Lob
    private String img_url;
    @Lob
    private String v_url;
    @Lob
    private String description;
    @Column(name = "created_date")
    @CreationTimestamp
    private LocalDateTime createdDate;
}
