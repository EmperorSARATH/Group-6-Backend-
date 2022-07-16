package com.example.healthcare.service;

import com.example.healthcare.entities.Patient;
import com.example.healthcare.entities.TestResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatientService {
    public List<Patient> getAll();

    public Patient registerPatient(Patient patient);
    Patient updatePatientDetails(int id, Patient patient);
    public Patient viewPatient(int id);
    public Patient getAllTestResult(String patientUserName);
    public TestResult viewTestResult(Integer testResultId);

}
