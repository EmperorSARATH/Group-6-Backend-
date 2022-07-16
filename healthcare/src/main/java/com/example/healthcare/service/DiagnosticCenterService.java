package com.example.healthcare.service;

import com.example.healthcare.exception.DiagnosticCenterNotFoundException;
import com.example.healthcare.exception.DiagnosticTestNotFoundException;
import com.example.healthcare.entities.Appointment;
import com.example.healthcare.entities.DiagnosticCenter;
import com.example.healthcare.entities.DiagnosticTest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DiagnosticCenterService {

    public List<DiagnosticCenter> getAllDiagnosticCenters();

    public DiagnosticCenter addDiagnosticCenter( DiagnosticCenter diagnosticCenter);

    public DiagnosticCenter getDiagnosticCenterById( Integer diagnosticCenterId) throws DiagnosticTestNotFoundException, DiagnosticCenterNotFoundException;

    public DiagnosticCenter updateDiagnosticCenter( DiagnosticCenter diagnosticCenter) throws DiagnosticTestNotFoundException, DiagnosticCenterNotFoundException;

    public DiagnosticTest viewTestDetails( Integer diagnosticCenterId, String testName);

    public DiagnosticTest addTest( Integer diagnosticCenterId, Integer testId);

    public DiagnosticCenter getDiagnosticCenter( String centerName);

    public List<DiagnosticCenter> removeDiagnosticCenter( Integer id);

    public List<Appointment> getListOfAppointments(String centerName);

    //Temp
    public DiagnosticTest getDiagnosticTestById( Integer diagnosticTestId);

}