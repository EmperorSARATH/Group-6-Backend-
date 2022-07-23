package com.example.healthcare.service;

import com.example.healthcare.entities.Appointment;
import com.example.healthcare.entities.DiagnosticTest;
import com.example.healthcare.dao.TestRepository;
import com.example.healthcare.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestRepository testRepository;

    @Override
    public DiagnosticTest addTest(DiagnosticTest test){
        testRepository.save(test);
        return test;
    }
    @Override
    public DiagnosticTest updateTest(DiagnosticTest test){
        DiagnosticTest dt = null;
        Optional<DiagnosticTest> optionalDiagnosticTest = testRepository.findById(test.getId());
        if(optionalDiagnosticTest.isPresent())
            dt = optionalDiagnosticTest.get();

        dt.setTestName(test.getTestName());
        dt.setTestPrice(test.getTestPrice());
        dt.setNormalValue(test.getNormalValue());
        dt.setUnits(test.getUnits());
        return testRepository.save(dt);
    }

    @Override
    public List<DiagnosticTest> viewAllTests(){
        return testRepository.findAll();
    }

    @Override
    public DiagnosticTest removeTest(DiagnosticTest test) {
        return null;
    }

//    @Override
//    public DiagnosticTest removeTest(DiagnosticTest test) {
//        Optional<DiagnosticTest> testTemp = testRepository.findById(test.getId());
//
//            testRepository.deleteById(test.getId());
//
//
//        return test;
//    }

    public String deleteById(int id) {

        String output;

        try {
            testRepository.deleteById(id);
            output = "delete okay...";

        }catch(Exception e) {
            output = "delete not okay...";
        }
        return output;

    }


}
