package com.example.healthcare.service;
import com.example.healthcare.exception.DiagnosticCenterNotFoundException;
import com.example.healthcare.exception.DiagnosticTestNotFoundException;
import com.example.healthcare.entities.Appointment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service

public interface AppointmentService {

    public List<Appointment> getAllAppointments();
    public Appointment addAppointment(Appointment appointment);

    public Set<Appointment>  viewAppointments(String patientName);

    public Optional<Appointment> viewAppointment(int Appointment);

    public Appointment updateAppointment(Appointment appointment);

    public List<Appointment> getAppointmentList(int centreid,String test,boolean status);

//    public Appointment removeAppointment(Appointment appointment);

    public List<Appointment> removeAppointment(Integer id);


    public Appointment addAppointment(int patientId, int testCenterid, int testId,String date) throws DiagnosticTestNotFoundException, DiagnosticCenterNotFoundException;
}