package com.example.healthcare.controller;

import com.example.healthcare.exception.DiagnosticCenterNotFoundException;
import com.example.healthcare.exception.DiagnosticTestNotFoundException;
import com.example.healthcare.entities.DiagnosticCenter;
import com.example.healthcare.entities.DiagnosticTest;
import com.example.healthcare.service.DiagnosticCenterService;
import com.example.healthcare.service.DiagnosticTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/DiagnosticCenter")
public class DiagnosticCenterController {
    @Autowired
    private DiagnosticCenterService diagnosticCenterService;

    @Autowired
    private DiagnosticTestService diagnosticTestService;

    @PostMapping("/add")
    public ResponseEntity<DiagnosticCenter> add(@RequestBody DiagnosticCenter diagnosticCenter)
    {
    DiagnosticCenter diagnostic= diagnosticCenterService.addDiagnosticCenter(diagnosticCenter);
     return new ResponseEntity<>(diagnostic, HttpStatus.ACCEPTED);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<DiagnosticCenter>> getAllDiagnosticCenters()
    {
        return ResponseEntity.ok(this.diagnosticCenterService.getAllDiagnosticCenters());

    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<DiagnosticCenter> fetchById(@PathVariable Integer id) throws DiagnosticCenterNotFoundException, DiagnosticTestNotFoundException {
        return ResponseEntity.ok(this.diagnosticCenterService.getDiagnosticCenterById(id));

    }

    @PutMapping("/update")
    public ResponseEntity<DiagnosticCenter> update(@RequestBody DiagnosticCenter diagnosticCenter) throws DiagnosticTestNotFoundException, DiagnosticCenterNotFoundException {
        return ResponseEntity.ok(this.diagnosticCenterService.updateDiagnosticCenter(diagnosticCenter));
    }

    @GetMapping("/viewtest/{centerId}/{testName}")
    public ResponseEntity<DiagnosticTest> viewTestDetails(@PathVariable Integer centerId,@PathVariable String testName)
    {
        return ResponseEntity.ok(this.diagnosticCenterService.viewTestDetails(centerId,testName));
    }

    @PostMapping("/addtest/{diagnosticcenterId}/{testid}")
    public ResponseEntity<DiagnosticTest> addTest(@PathVariable Integer diagnosticcenterId, @PathVariable Integer testid)
    {
        return ResponseEntity.ok(this.diagnosticCenterService.addTest(diagnosticcenterId,testid));
    }

    @GetMapping("/getbyname/{name}")
    public DiagnosticCenter fetchByName(@PathVariable String name) {
        return diagnosticCenterService.getDiagnosticCenter(name);
    }

    @DeleteMapping("remove/{id}")
    public List<DiagnosticCenter> removeDiagnosticCenter(@PathVariable Integer id)
    {
        return diagnosticCenterService.removeDiagnosticCenter(id);
    }

    @GetMapping("/gettestbyid/{id}")
    public DiagnosticTest fetchTestById(@PathVariable Integer id) {
        return diagnosticCenterService.getDiagnosticTestById(id);

    }

}