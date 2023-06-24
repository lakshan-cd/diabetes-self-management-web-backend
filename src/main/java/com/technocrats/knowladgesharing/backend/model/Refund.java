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
@Table(name = "refundpayment")
public class Refund {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "refundpayment_generator")
    private Long refundid;
    private String reason;
}
