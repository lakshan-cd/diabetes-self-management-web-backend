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
@Table(name = "reservation")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "payment_generator")
    private Long p_id;
}
