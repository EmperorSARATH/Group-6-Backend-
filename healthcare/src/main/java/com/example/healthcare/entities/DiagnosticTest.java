package com.example.healthcare.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

import static javax.persistence.GenerationType.AUTO;

@Data
@Entity
@NoArgsConstructor
@Table(name = "DiagnosticTest")
public class DiagnosticTest {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Integer id;
    @NotNull(message = "Please Enter Diagnostic Test Name:")
    private String testName;
    @NotNull(message = "Please Enter Diagnostic Test Price:")
    private double testPrice;
    @NotNull(message = "Please Enter Diagnostic Test Normal Value:")
    private String normalValue;

    @NotNull(message = "Please Enter Diagnostic Center Units:")
    private String units;

    //@NotNull(message= "Please Enter Diagnostic Test Centers:")
    @OneToMany(targetEntity = DiagnosticCenter.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "", referencedColumnName = "id")
    @JsonIgnore
    private Set<DiagnosticCenter> diagnosticCenters;

    public DiagnosticTest(String normalValue, String testName, double testPrice, String units){
        this.normalValue = normalValue;
        this.testName = testName;
        this.testPrice = testPrice;
        this.units = units;
    }

}
