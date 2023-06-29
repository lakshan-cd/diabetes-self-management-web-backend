package com.technocrats.knowladgesharing.backend.repository;

import com.technocrats.knowladgesharing.backend.model.MedicalReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicalReportRepository extends JpaRepository<MedicalReport , Long> {

    List<MedicalReport> findByPidAndDid(int pid, int did);
    List<MedicalReport> findByPidAndNid(int pid, int nid);
}
