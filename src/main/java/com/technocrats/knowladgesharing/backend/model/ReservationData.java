package com.technocrats.knowladgesharing.backend.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@ToString
@Getter
@Setter
@Table(name = "refund_details")
public class ReservationData {



    @Column(name = "account_holder_name")
    private String account_holder_name;

    @Column(name = "bank")
    private String bank;

    @Column(name = "account_number")
    private String account_number;


    @Column(name = "mobile_number")
    private String mobile_number;


    @Column(name = "customer_name")
    private String customer_name;


    @Column(name = "booking_date")
    private String booking_date;
    @Id
    private Long id;

    // Default construct

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount_holder_name() {
        return account_holder_name;
    }

    public void setAccount_holder_name(String account_holder_name) {
        this.account_holder_name = account_holder_name;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getBooking_date() {
        return booking_date;
    }

    public void setBooking_date(String booking_date) {
        this.booking_date = booking_date;
    }

    public ReservationData(Long id, String account_holder_name, String bank, String account_number, String mobile_number, String customer_name, String booking_date) {
        this.id = id;
        this.account_holder_name = account_holder_name;
        this.bank = bank;
        this.account_number = account_number;
        this.mobile_number = mobile_number;
        this.customer_name = customer_name;
        this.booking_date = booking_date;
    }


}
