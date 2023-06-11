package com.technocrats.knowladgesharing.backend.service;

import com.technocrats.knowladgesharing.backend.model.Reservation;
import com.technocrats.knowladgesharing.backend.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    //get all data from the table

    public List<Reservation> getAllData() {
        return reservationRepository.findAll();
    }

    //add data to the table

    public Reservation addReservation (Reservation reservation){
        return reservationRepository.save(reservation);
    }
}
