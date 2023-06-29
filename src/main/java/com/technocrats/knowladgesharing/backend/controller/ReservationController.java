package com.technocrats.knowladgesharing.backend.controller;


import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.technocrats.knowladgesharing.backend.model.*;
import com.technocrats.knowladgesharing.backend.service.RefundDetailsService;
import com.technocrats.knowladgesharing.backend.service.ReservationRequestObject;
import com.technocrats.knowladgesharing.backend.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

//    @GetMapping("/create")
@PostMapping("/create")
public String createPaymentIntent(@RequestBody PaymentRequest paymentRequest) {
    try {
        Stripe.apiKey = "sk_test_51NL9DjF3tLE6ePN10EjZ7hPWJdcx7RDAGjizdSBrsG2HmiSJ5G0fYAbKSWRaHHTo9NHNt25B9UMcA4eqqZJnqYKq00Z3mMJ12n";

        Map<String, Object> params = new HashMap<>();
        params.put("amount", paymentRequest.getAmount());
        params.put("currency", paymentRequest.getCurrency());
        params.put("payment_method_types", Collections.singletonList("card"));

        PaymentIntent paymentIntent = PaymentIntent.create(params);

        Map<String, String> response = new HashMap<>();
//        response.put("clientSecret", paymentIntent.getClientSecret());

//        System.out.println(response);
        return ("ResponseEntity.ok(response)");
    } catch (StripeException e) {
        return  ("a");
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("error", e.getMessage()));
    }
}


    @ExceptionHandler(StripeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleStripeException(StripeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
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
            reservationService.deleteReservation(reservationData.getId());

            return ResponseEntity.ok("Reservation deleted successfully and data inserted into table");
    }
}