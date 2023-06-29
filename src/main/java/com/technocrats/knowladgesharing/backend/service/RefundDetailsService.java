package com.technocrats.knowladgesharing.backend.service;

import com.technocrats.knowladgesharing.backend.model.ReservationData;
import com.technocrats.knowladgesharing.backend.repository.RefundRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RefundDetailsService {

    @Autowired
    private RefundRepositroy refundRepositroy;

    public ReservationData insertRefundDetails(ReservationData reservationData) {

        return refundRepositroy.save(reservationData);// Implement the logic to insert data into the refundDetails table
// using the provided parameters
    }

}
