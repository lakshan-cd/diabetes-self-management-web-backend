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
@Table(name = "medicine")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "medicine_generator")
    private Long m_id;
    @Lob
    private String description;
    private String m_name; //should be in seperate table
}
