package com.technocrats.knowladgesharing.backend.repository;

import com.technocrats.knowladgesharing.backend.model.KInformation;
import com.technocrats.knowladgesharing.backend.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation ,Long > {

//    List<Reservation> findByTime(Long pId);
//            List<Reservation> findByPid(Long pId);
        @Query("SELECT u FROM Reservation u WHERE u.d_id=?1 AND u.r_type=?2 AND u.isremove =?3")
    List<Reservation> getReservationsByRoleAndDocId(Long dId, String type ,String isremoved);

    @Query("SELECT u FROM Reservation u WHERE u.p_id=?1 AND u.r_type=?2")
    List<Reservation> getReservationsByPatient(Long pId, String type);

    @Query("SELECT u FROM Reservation u WHERE u.isremove=?1")
    List<Reservation> getAllCanceledReservations(String isremoved);


    @Query("SELECT u FROM Reservation u WHERE u.p_id=?1 AND u.isremove=?2")
    List<Reservation> getReservationsByPId(Long pId, String no);
}
