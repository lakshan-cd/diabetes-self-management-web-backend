package com.technocrats.knowladgesharing.backend.service;

import com.technocrats.knowladgesharing.backend.exception.ResourceNotFoundException;
import com.technocrats.knowladgesharing.backend.model.KInformation;
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

//    public List<Reservation> getReservationsByPId(Long pId) {
//        return reservationRepository.findByP_id(pId);
//    }

    public List<Reservation> getReservationsByPId(Long pId) {
        return reservationRepository.getReservationsByPId(pId,"no");
    }

    //get by id
    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }


    public List<Reservation> getReservationsByRoleAndDocId(Long dId, String type) {
        return reservationRepository.getReservationsByRoleAndDocId(dId,type,"no");
    }

    public List<Reservation> getReservationsByPatient(Long pId, String type) {
        return reservationRepository.getReservationsByPatient(pId,type);
    }

    public List<Reservation> getAllCanceledReservations() {
        return reservationRepository.getAllCanceledReservations("yes");
    }

    public boolean deleteReservation(Long id) {
        reservationRepository.deleteById(id);
        return true;
    }
}
