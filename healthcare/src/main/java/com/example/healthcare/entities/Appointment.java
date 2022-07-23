package com.example.healthcare.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull(message="Please enter your appointment date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private String date;

    @NotNull(message="Please enter the approval status")
    private boolean approvalStatus;

    @OneToOne(targetEntity = DiagnosticTest.class, cascade = CascadeType.ALL)
    @JoinColumn (name = "diat_apmt", referencedColumnName = "id")

   private DiagnosticTest diagnosticTests;

    @OneToMany(targetEntity = Patient.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "pat_apmt", referencedColumnName = "id")

    private Set<Patient> patient;

    @OneToMany(targetEntity = DiagnosticCenter.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "diac_apmt", referencedColumnName = "id")

    private Set<DiagnosticCenter> diagnosticCenter;


    @OneToMany(targetEntity = TestResult.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "test_apmt", referencedColumnName = "id")



    private Set<TestResult> testResults;


    public Appointment(String date, boolean approvalStatus) {
        this.date=date;
        this.approvalStatus = approvalStatus;
    }
}










