package com.technocrats.knowladgesharing.backend.repository;

import com.technocrats.knowladgesharing.backend.model.Reservation;
import com.technocrats.knowladgesharing.backend.model.ReservationData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefundRepositroy extends JpaRepository<ReservationData , Long> {
}
