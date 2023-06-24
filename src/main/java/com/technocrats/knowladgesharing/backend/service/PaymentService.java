package com.technocrats.knowladgesharing.backend.service;

import com.technocrats.knowladgesharing.backend.model.Payment;
import com.technocrats.knowladgesharing.backend.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment addNewPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public List<Payment> getAllPayment() {
        return paymentRepository.findAll();
    }
}
