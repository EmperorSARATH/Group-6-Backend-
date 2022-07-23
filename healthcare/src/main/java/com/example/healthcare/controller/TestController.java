package com.example.healthcare.controller;

import com.example.healthcare.entities.Appointment;
import com.example.healthcare.entities.DiagnosticCenter;
import com.example.healthcare.entities.DiagnosticTest;
import com.example.healthcare.entities.User;
import com.example.healthcare.service.DiagnosticTestService;
import com.example.healthcare.service.TestService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("")
public class TestController {
    @Autowired
    private TestService testService;
    @Autowired
    private DiagnosticTestService diagnosticTestService;

    @ApiOperation("add test")
    @PostMapping("/addtest")
    public ResponseEntity<DiagnosticTest> addTest(@Valid @RequestBody DiagnosticTest test){
        DiagnosticTest newTest = testService.addTest(test);
        log.info("New test created");
        return new ResponseEntity<>(newTest, HttpStatus.CREATED);
    }

    @ApiOperation("update test")
    @PutMapping("/updatetest")
    public ResponseEntity<DiagnosticTest> updateTest(@Valid @RequestBody DiagnosticTest test){
        DiagnosticTest updateTest = testService.updateTest(test);
        log.info("Update test");
        return new ResponseEntity<>(updateTest,HttpStatus.ACCEPTED);
    }

//    @ApiOperation("delete test")
//    @DeleteMapping("/removetest")
//    public ResponseEntity<DiagnosticTest> removeTest(@Valid @RequestBody DiagnosticTest test){
//        DiagnosticTest deleteTest = testService.removeTest(test);
//        log.info("Remove test");
//        return new ResponseEntity<>(deleteTest,HttpStatus.ACCEPTED);
//    }

//    @DeleteMapping("/remove")
//    public ResponseEntity<DiagnosticTest> removeTest(@RequestBody DiagnosticTest test) {
//        DiagnosticTest testRemoved = testService.removeTest(test);
//
//            return new ResponseEntity<>(test, HttpStatus.ACCEPTED);
//    }


    @DeleteMapping("/deleteDataById/{id}")
    public String deleteDataById(@PathVariable int id) {
        return testService.deleteById(id);
    }

    @ApiOperation("view all the test")
    @GetMapping("/viewalltest")
    public List<DiagnosticTest> viewAllTests(){
        log.info("View all tests");
        return testService.viewAllTests();
    }
}
