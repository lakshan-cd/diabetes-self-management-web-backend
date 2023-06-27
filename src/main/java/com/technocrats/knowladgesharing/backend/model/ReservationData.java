package com.technocrats.knowladgesharing.backend.model;

public class ReservationData {
    private Long id;
    private String account_holder_name;
    private String bank;
    private String account_number;
    private String mobile_number;
    private String customer_name;
    private String booking_date;

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
