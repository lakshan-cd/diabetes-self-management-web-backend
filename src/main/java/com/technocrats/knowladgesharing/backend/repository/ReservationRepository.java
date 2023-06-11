package com.technocrats.knowladgesharing.backend.repository;

import com.technocrats.knowladgesharing.backend.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation ,Long > {
}
