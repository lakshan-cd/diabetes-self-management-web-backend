package com.technocrats.knowladgesharing.backend.controller;


import com.technocrats.knowladgesharing.backend.model.Reservation;
import com.technocrats.knowladgesharing.backend.service.ReservationRequestObject;
import com.technocrats.knowladgesharing.backend.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://10.10.6.123")

public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    //get all data
    @GetMapping("/getAllReservations")
    public List<Reservation> getAllData (){
        return reservationService.getAllData();
    }

    @PostMapping("/addReservation")
    public Reservation addReservation(@RequestBody ReservationRequestObject reservationRequestObject){

        Reservation ra = new Reservation();
        ra.setP_name(reservationRequestObject.getP_name());
        ra.setR_type(reservationRequestObject.getR_type());
        ra.setPhone_no(reservationRequestObject.getPhone_no());
        ra.setDate(reservationRequestObject.getDate());
        ra.setTime(reservationRequestObject.getTime());

        return reservationService.addReservation(ra); //send data to update database

    }

}
