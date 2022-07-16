package com.example.healthcare.dao;

import com.example.healthcare.entities.Appointment;
import com.example.healthcare.entities.DiagnosticCenter;
import com.example.healthcare.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository <Appointment,Integer> {

    public Patient findByPatient(Patient patient);
    public List<Appointment> findByDiagnosticCenter(DiagnosticCenter diagnosticCenter);
}