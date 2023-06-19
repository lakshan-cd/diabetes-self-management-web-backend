package com.technocrats.knowladgesharing.backend.controller;

import com.technocrats.knowladgesharing.backend.dto.MedicalReportInputRequestObject;
import com.technocrats.knowladgesharing.backend.dto.PayementInputRequest;
import com.technocrats.knowladgesharing.backend.model.KInformation;
import com.technocrats.knowladgesharing.backend.model.MedicalReport;
import com.technocrats.knowladgesharing.backend.model.Payment;
import com.technocrats.knowladgesharing.backend.service.PaymentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @PostMapping("/addNewPayment")
    public ResponseEntity<Payment> addNewPayment(@RequestBody PayementInputRequest payementInputRequest) {
        Payment payment = new Payment();
        BeanUtils.copyProperties(payementInputRequest, payment);

        Payment savePayment = paymentService.addNewPayment(payment);
        return new ResponseEntity<>(savePayment, HttpStatus.CREATED);

    }

    @GetMapping("/getAllPayment")
    public List<Payment> getAllPayment(){
        return paymentService.getAllPayment();
    }




}
