package com.technocrats.knowladgesharing.backend.controller;


import com.technocrats.knowladgesharing.backend.model.KInformation;
import com.technocrats.knowladgesharing.backend.model.Refund;
import com.technocrats.knowladgesharing.backend.model.Reservation;
import com.technocrats.knowladgesharing.backend.model.ReservationData;
import com.technocrats.knowladgesharing.backend.service.RefundDetailsService;
import com.technocrats.knowladgesharing.backend.service.ReservationRequestObject;
import com.technocrats.knowladgesharing.backend.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")

public class ReservationController {

    @Autowired
    private RefundDetailsService refundDetailsService;

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
//        ra.setP_id(reservationRequestObject.getP_id());
        ra.setP_id(reservationRequestObject.getP_id());
        ra.setD_id(reservationRequestObject.getD_id());
        ra.setIsremove(reservationRequestObject.getIsremove());


        return reservationService.addReservation(ra); //send data to update database

    }
//    @GetMapping("/getReservationByPatientId/{p_id}")
//    public List<Reservation> getReservationsByPId(@PathVariable("pId") Long pId) {
//        return reservationService.getReservationsByPId(pId);
//    }

    @GetMapping("/getReservationsById/{pId}")
    public List<Reservation> getReservationsByPId(@PathVariable Long pId) {
        return reservationService.getReservationsByPId(pId);
    }

    //


    //update whether to find user cancel or not
    @PutMapping("/updateReservation/{id}")
    public Reservation addReservation(@PathVariable Long id , @RequestBody ReservationRequestObject reservationRequestObject){
        Reservation ra = reservationService.getReservationById(id);

        ra.setIsremove(reservationRequestObject.getIsremove());

        return reservationService.addReservation(ra); //send data to update database

    }


    //showing to doc and nutritionist
    @GetMapping("/getReservationsByRole/{dId}/{Type}")
    public List<Reservation> getReservationsByRoleAndDocId(@PathVariable Long dId,@PathVariable String Type) {
        return reservationService.getReservationsByRoleAndDocId(dId,Type);
    }

    //show reservations for patient by categorizing by doc and nutritionist
    @GetMapping("/getReservationsByPatient/{pId}/{Type}")
    public List<Reservation> getReservationsForPatient(@PathVariable Long pId, @PathVariable String Type) {
        return reservationService.getReservationsByPatient(pId,Type);
    }

    //get all canceled reservations
    @GetMapping("/getAllCancledReservations")
    public List<Reservation> getAllCanceledReservations() {
        return reservationService.getAllCanceledReservations();
    }


    @DeleteMapping("/deleteReservation")
    public ResponseEntity<Object> deleteReservation(@RequestBody ReservationData reservationData) {
        Long id = reservationData.getId();
        String accountHolderName = reservationData.getAccount_holder_name();
        String bank = reservationData.getBank();
        String accountNumber = reservationData.getAccount_number();
        String mobileNumber = reservationData.getMobile_number();
        String customerName = reservationData.getCustomer_name();
        String bookingDate = reservationData.getBooking_date();
        ReservationData reservationData1 = new ReservationData(id , accountHolderName, bank, accountNumber, mobileNumber, customerName, bookingDate);
            System.out.println(reservationData.getAccount_holder_name());
            refundDetailsService.insertRefundDetails(reservationData1);
            return ResponseEntity.ok("Reservation deleted successfully and data inserted into table");
    }
}